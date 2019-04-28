/*
 * Copyright (c) 2019 ThanksMister LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thanksmister.things.wallpanel.modules

import android.annotation.SuppressLint
import android.arch.lifecycle.*
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageFormat
import android.graphics.Matrix
import android.hardware.camera2.*
import android.media.ImageReader
import android.os.AsyncTask
import android.os.Handler
import android.view.Surface
import android.view.SurfaceHolder
import com.thanksmister.things.wallpanel.R
import com.thanksmister.things.wallpanel.persistence.Configuration
import timber.log.Timber
import java.io.ByteArrayOutputStream
import android.hardware.camera2.CameraAccessException
import android.graphics.SurfaceTexture
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.params.StreamConfigurationMap
import android.hardware.camera2.CameraManager

import android.os.HandlerThread
import android.support.annotation.NonNull
import android.util.Size
import android.view.SurfaceView
import android.view.TextureView
import android.widget.Toast
import java.nio.ByteBuffer

import java.util.*
import kotlin.Comparator


/**
 * Module to take photo and email when alarm is disabled if camera available.
 */
class CameraModule(base: Context,
                   private val configuration: Configuration,
                   private var callback: CallbackListener?) : ContextWrapper(base), LifecycleObserver {

    fun getJpeg(): LiveData<ByteArray> {
        return byteArray
    }

    private fun setJpeg(value: ByteArray) {
        this.byteArray.value = value
    }

    private val byteArray = MutableLiveData<ByteArray>()
    private var bitmapComplete = true;
    private var byteArrayCreateTask: ByteArrayTask? = null
    private var mImageReader: ImageReader? = null
    private var mCameraDevice: CameraDevice? = null
    private var mCaptureSession: CameraCaptureSession? = null
    private var hasCamera:Boolean = false
    private var cameraId:String? = null
    private var imageDimension: Size? = null
    private var backgroundThread: HandlerThread? = null
    private var backgroundHandler: Handler? = null

    interface CallbackListener {
        fun onCameraReady()
        fun onCameraException(message: String)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    @SuppressLint("MissingPermission")
    fun onStart() {
        Timber.e("onStart")
        setupCamera()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onStop() {
        Timber.e("onStop")
        stopBackgroundThread()
        hasCamera = false
        mCameraDevice?.close()
        mCameraDevice = null
        byteArrayCreateTask?.cancel(true)
        byteArrayCreateTask = null
        mImageReader?.close()
        mImageReader = null
    }

    // Start camera for MJPEG streaming service
    fun startCamera() {
        Timber.d("startCamera")
        if(hasCamera) {
            mImageReader = ImageReader.newInstance(IMAGE_WIDTH, IMAGE_HEIGHT, ImageFormat.JPEG, MAX_IMAGES)
            mImageReader?.setOnImageAvailableListener(imageAvailableListener, backgroundHandler)
            mCameraDevice?.createCaptureSession(arrayListOf(mImageReader?.surface), mSessionCallback, null)
            captureRequestBuilder = mCameraDevice?.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE)
            captureRequestBuilder?.set(CaptureRequest.JPEG_ORIENTATION, configuration.cameraRotate.toInt())
            captureRequestBuilder?.addTarget(mImageReader?.surface)
        }
    }

    // Start a camera preview that is continuously upating the surface view
    fun startCameraPreview(surfaceTexture: SurfaceTexture) {
        Timber.d("startCameraPreview $hasCamera")
        if(hasCamera) {
            val surface = Surface(surfaceTexture)
            try {
                val previewRequestBuilder = mCameraDevice?.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)
                previewRequestBuilder?.set(CaptureRequest.JPEG_ORIENTATION, configuration.cameraRotate.toInt())
                previewRequestBuilder?.addTarget(surface)

                mCameraDevice?.createCaptureSession(Collections.singletonList(surface), object : CameraCaptureSession.StateCallback() {
                    override fun onConfigured(@NonNull session: CameraCaptureSession) {
                        mCaptureSession = session
                        try {
                            mCaptureSession?.setRepeatingRequest(previewRequestBuilder?.build(), null, backgroundHandler)
                        } catch (e: CameraAccessException) {
                            Timber.e(e.message)
                            callback?.onCameraException(e.message ?:"CameraAccessException")
                        }
                    }
                    override fun onConfigureFailed(@NonNull session: CameraCaptureSession) {
                        Timber.e("onConfigureFailed: Failed ")
                        callback?.onCameraException("Configuration change")
                    }
                }, backgroundHandler)
            } catch (e: CameraAccessException) {
                Timber.e(e.message)
                callback?.onCameraException(e.message ?:"CameraAccessException")
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun setupCamera() {
        startBackgroundThread()
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            for (cameraId in cameraManager.cameraIdList) {
                val cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraId)
                if (cameraCharacteristics.get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_BACK) {
                    continue
                }
                val map = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
                imageDimension = map.getOutputSizes(SurfaceTexture::class.java)[0]
                hasCamera = true
                this.cameraId = cameraId
                cameraManager.openCamera(cameraId, mStateCallback, backgroundHandler)
                return
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun startBackgroundThread() {
        backgroundThread = HandlerThread("Camera Background");
        backgroundThread?.start();
        backgroundHandler = Handler(backgroundThread?.looper);
    }

    private fun stopBackgroundThread() {
        backgroundThread?.quitSafely()
        try {
            backgroundThread?.join()
            backgroundThread = null
            backgroundHandler = null
        } catch (e: InterruptedException) {
            e.printStackTrace();
        }
    }

    // TODO on camera preview maybe we can setup the call to surface automatically
    // Called as part of the camera setup process
    private val mStateCallback = object : CameraDevice.StateCallback() {
        override fun onError(cameraDevice: CameraDevice, code: Int) {
            Timber.e("Camera device error, closing")
            cameraDevice.close()
            callback?.onCameraException(getString(R.string.toast_camera_source_error));
        }
        override fun onOpened(cameraDevice: CameraDevice) {
            Timber.d("Opened camera.")
            mCameraDevice = cameraDevice
            callback?.onCameraReady();
        }
        override fun onDisconnected(cameraDevice: CameraDevice) {
            Timber.d("Camera disconnected, closing")
            cameraDevice.close()
        }
        override fun onClosed(camera: CameraDevice) {
            Timber.d("Closed camera, releasing")
            mCameraDevice = null
        }
    }

    private val mSessionCallback = object : CameraCaptureSession.StateCallback() {
        override fun onConfigureFailed(cameraCaptureSession: CameraCaptureSession?) {
            Timber.d("Failed to configure camera")
            callback?.onCameraException("Failed to configure camera");
        }
        override fun onConfigured(cameraCaptureSession: CameraCaptureSession?) {
            if (mCameraDevice == null) {
                return
            }
            mCaptureSession = cameraCaptureSession
            try {
                mCaptureSession?.capture(captureRequestBuilder?.build(), mCaptureCallback, null)
                startStillCaptureRequest()
            } catch (e: CameraAccessException) {
                e.printStackTrace()
            }
        }
    }

    private var captureRequestBuilder: CaptureRequest.Builder? = null

    private fun startStillCaptureRequest() {
        if (hasCamera) {
            mCaptureSession?.capture(captureRequestBuilder?.build(), mCaptureCallback, null)
        }
    }

    private val mCaptureCallback = object : CameraCaptureSession.CaptureCallback() {
        override fun onCaptureProgressed(session: CameraCaptureSession?, request: CaptureRequest?, partialResult: CaptureResult?) {
            Timber.d("Partial result")
        }
        override fun onCaptureFailed(session: CameraCaptureSession?, request: CaptureRequest?, failure: CaptureFailure?) {
            Timber.d("Capture session failed")
            callback?.onCameraException("Camera Failed Session");
        }
        override fun onCaptureCompleted(session: CameraCaptureSession?, request: CaptureRequest?, result: TotalCaptureResult?) {
            Timber.d("Capture complete request another capture")
            startStillCaptureRequest()
        }
    }

    private val imageAvailableListener = ImageReader.OnImageAvailableListener { reader ->
        Timber.d("imageAvailableListener")
        val image = reader.acquireNextImage()
        val imageBuffer = image.planes[0].buffer
        val imageBytes = ByteArray(imageBuffer.remaining())
        imageBuffer.get(imageBytes)
        image.close()
        if(imageBytes.isNotEmpty()) {
            processSnapShotFromBytes(imageBytes)
        }
    }

    private fun processSnapShotFromBytes (byteArray: ByteArray) {
        Timber.d("processSnapShotFromBytes")
        if (bitmapComplete) {
            byteArrayCreateTask = ByteArrayTask(object : OnCompleteListener {
                override fun onComplete(byteArray: ByteArray?) {
                    bitmapComplete = true
                    byteArray?.let {
                        setJpeg(it)
                    }
                }
            })
            bitmapComplete = false
            byteArrayCreateTask!!.execute(byteArray, configuration.cameraRotate)
        }
    }

    private fun triggerImageCapture() {
        if(hasCamera) {
            val captureBuilder = mCameraDevice?.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE)
            captureBuilder?.addTarget(mImageReader?.surface)
            mCaptureSession?.capture(captureBuilder?.build(), mCaptureCallback, null)
        }
    }

    private interface OnCompleteListener {
        fun onComplete(byteArray: ByteArray?)
    }

    private class ByteArrayTask(private val onCompleteListener: OnCompleteListener) : AsyncTask<Any, Void, ByteArray>() {

        override fun doInBackground(vararg params: kotlin.Any): ByteArray? {
            if (isCancelled) {
                return null
            }
            val byteArray = params[0] as ByteArray
            val rotation = params[1] as Float
            val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            val bytes = bitmap.byteCount
            val buffer = ByteBuffer.allocate(bytes); // Create a new buffer
            bitmap.copyPixelsToBuffer(buffer); // Move the byte data to the buffer

            val matrix = Matrix()
            matrix.postRotate(rotation)

            val bitmapOutput = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
            val stream = ByteArrayOutputStream()
            bitmapOutput.compress(Bitmap.CompressFormat.JPEG, 100, stream)

            val byteArrayOut = stream.toByteArray()
            bitmapOutput.recycle()
            return byteArrayOut
        }

        override fun onPostExecute(result: ByteArray?) {
            super.onPostExecute(result)
            if (isCancelled) {
                return
            }
            onCompleteListener.onComplete(result)
        }
    }

    companion object InstanceHolder {
        val IMAGE_WIDTH = 640
        val IMAGE_HEIGHT = 480
        val MAX_IMAGES = 1
    }
}