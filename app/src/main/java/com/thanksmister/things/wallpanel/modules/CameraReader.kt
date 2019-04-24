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
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import android.hardware.Camera
import android.os.AsyncTask
import android.support.v8.renderscript.RenderScript
import android.view.Surface
import android.view.WindowManager
import com.google.android.gms.vision.*
import com.google.android.gms.vision.CameraSource.CAMERA_FACING_BACK
import com.google.android.gms.vision.CameraSource.CAMERA_FACING_FRONT
import com.thanksmister.things.wallpanel.persistence.Configuration
import com.thanksmister.things.wallpanel.ui.views.CameraSourcePreview
import io.github.silvaren.easyrs.tools.Nv21Image
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.lang.ref.WeakReference
import javax.inject.Inject

class CameraReader @Inject
constructor(private val context: Context) {

    private val renderScript: RenderScript = RenderScript.create(context)
    private var cameraCallback: CameraCallback? = null

    private var multiDetector: MultiDetector? = null
    private var streamDetector: StreamingDetector? = null
    private var cameraSource: CameraSource? = null

    private var streamDetectorProcessor: MultiProcessor<Stream>? = null
    private val byteArray = MutableLiveData<ByteArray>()
    private var bitmapComplete = true;
    private var byteArrayCreateTask: ByteArrayTask? = null
    private var cameraOrientation: Int = 0
    private var cameraPreview: CameraSourcePreview? = null

    fun getJpeg(): LiveData<ByteArray> {
        return byteArray
    }

    private fun setJpeg(value: ByteArray) {
        this.byteArray.value = value
    }

    fun stopCamera() {

        if (byteArrayCreateTask != null) {
            byteArrayCreateTask!!.cancel(true)
            byteArrayCreateTask = null
        }

        if (cameraSource != null) {
            cameraSource!!.release()
            cameraSource = null
        }

        if (streamDetector != null) {
            streamDetector!!.release()
            streamDetector = null
        }

        if (multiDetector != null) {
            multiDetector!!.release()
            multiDetector = null
        }

        if (streamDetectorProcessor != null) {
            streamDetectorProcessor!!.release()
            streamDetectorProcessor = null
        }
    }

    @SuppressLint("MissingPermission")
    fun startCamera(callback: CameraCallback, configuration: Configuration) {
        Timber.d("startCamera")
        this.cameraCallback = callback
        if (configuration.cameraEnabled) {
            buildDetectors(configuration)
            if(multiDetector != null) {
                try {
                    cameraSource = initCamera(configuration.cameraId, configuration.cameraFPS)
                    cameraSource!!.start()
                } catch (e : Exception) {
                    Timber.e(e.message)
                    try {
                        if(configuration.cameraId == CAMERA_FACING_FRONT) {
                            cameraSource = initCamera(CAMERA_FACING_BACK, configuration.cameraFPS)
                            cameraSource!!.start()
                        } else {
                            cameraSource = initCamera(CAMERA_FACING_FRONT, configuration.cameraFPS)
                            cameraSource!!.start()
                        }
                    } catch (e : Exception) {
                        Timber.e(e.message)
                        cameraSource!!.stop()
                        cameraCallback?.onCameraError()
                    }
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    @Throws(IOException::class)
    fun startCameraPreview(callback: CameraCallback, configuration: Configuration, preview: CameraSourcePreview?) {
        Timber.d("startCameraPreview")
        if (configuration.cameraEnabled && preview != null) {
            this.cameraCallback = callback
            this.cameraPreview = preview
            buildDetectors(configuration)
            if(multiDetector != null) {
                cameraSource = initCamera(configuration.cameraId, configuration.cameraFPS)
                cameraPreview!!.start(cameraSource, object : CameraSourcePreview.OnCameraPreviewListener {
                    override fun onCameraError() {
                        Timber.e("Camera Preview Error")
                        cameraSource = if(configuration.cameraId == CAMERA_FACING_FRONT) {
                            initCamera(CAMERA_FACING_BACK, configuration.cameraFPS)
                        } else {
                            initCamera(CAMERA_FACING_FRONT, configuration.cameraFPS)
                        }
                        if(cameraPreview != null) {
                            try {
                                cameraPreview!!.start(cameraSource, object : CameraSourcePreview.OnCameraPreviewListener {
                                    override fun onCameraError() {
                                        Timber.e("Camera Preview Error")
                                        cameraCallback!!.onCameraError()
                                    }
                                })
                            } catch (e: Exception) {
                                Timber.e(e.message)
                                cameraPreview!!.stop()
                                cameraSource!!.stop()
                                cameraCallback!!.onCameraError()
                            }
                        }
                    }
                })
            }
        }
    }

    @SuppressLint("MissingPermission")
    @Throws(IOException::class)
    fun startCameraPreviewSolo(callback: CameraCallback, configuration: Configuration, preview: CameraSourcePreview?) {
        Timber.d("startCameraPreviewSolo")
        if (configuration.cameraEnabled && preview != null) {
            this.cameraCallback = callback
            this.cameraPreview = preview
            buildCameraDetector(configuration)
            if(multiDetector != null) {
                cameraSource = initCamera(configuration.cameraId, configuration.cameraFPS)
                cameraPreview!!.start(cameraSource, object : CameraSourcePreview.OnCameraPreviewListener {
                    override fun onCameraError() {
                        Timber.e("Camera Preview Error")
                        cameraSource = if(configuration.cameraId == CAMERA_FACING_FRONT) {
                            initCamera(CAMERA_FACING_BACK, configuration.cameraFPS)
                        } else {
                            initCamera(CAMERA_FACING_FRONT, configuration.cameraFPS)
                        }
                        if(cameraPreview != null) {
                            try {
                                cameraPreview!!.start(cameraSource, object : CameraSourcePreview.OnCameraPreviewListener {
                                    override fun onCameraError() {
                                        Timber.e("Camera Preview Error")
                                        cameraCallback!!.onCameraError()
                                    }
                                })
                            } catch (e: Exception) {
                                Timber.e(e.message)
                                cameraPreview!!.stop()
                                cameraSource!!.stop()
                                cameraCallback!!.onCameraError()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun buildCameraDetector(configuration: Configuration) {
        val info = Camera.CameraInfo()
        try{
            Camera.getCameraInfo(configuration.cameraId, info)
        } catch (e: RuntimeException) {
            Timber.e(e.message)
            cameraCallback!!.onCameraError()
            return
        }
        cameraOrientation = info.orientation
        val multiDetectorBuilder = MultiDetector.Builder()
        var detectorAdded = false
        if(configuration.cameraEnabled) {
            streamDetector = StreamingDetector.Builder().build()
            streamDetectorProcessor = MultiProcessor.Builder<Stream>(MultiProcessor.Factory<Stream> {
                object : Tracker<Stream>() {
                    override fun onUpdate(p0: Detector.Detections<Stream>?, stream: Stream?) {
                        super.onUpdate(p0, stream)
                    }
                }
            }).build()

            streamDetector!!.setProcessor(streamDetectorProcessor)
            multiDetectorBuilder.add(streamDetector)
            detectorAdded = true
        }

        if(detectorAdded) {
            multiDetector = multiDetectorBuilder.build()
        }
    }

    private fun buildDetectors(configuration: Configuration) {

        val info = Camera.CameraInfo()
        try{
            Camera.getCameraInfo(configuration.cameraId, info)
        } catch (e: RuntimeException) {
            Timber.e(e.message)
            cameraCallback!!.onCameraError()
            return
        }

        cameraOrientation = info.orientation
        val multiDetectorBuilder = MultiDetector.Builder()
        var detectorAdded = false

        if(configuration.cameraEnabled && configuration.httpMJPEGEnabled) {
            streamDetector = StreamingDetector.Builder().build()
            streamDetectorProcessor = MultiProcessor.Builder<Stream>(MultiProcessor.Factory<Stream> {
                object : Tracker<Stream>() {
                    override fun onUpdate(p0: Detector.Detections<Stream>?, stream: Stream?) {
                        super.onUpdate(p0, stream)
                        if (stream?.byteArray != null && bitmapComplete) {
                            byteArrayCreateTask = ByteArrayTask(context, renderScript, object : OnCompleteListener {
                                override fun onComplete(byteArray: ByteArray?) {
                                    bitmapComplete = true
                                    setJpeg(byteArray!!)
                                }
                            })
                            bitmapComplete = false
                            byteArrayCreateTask!!.execute(stream.byteArray, stream.width, stream.height, cameraOrientation, configuration.cameraRotate)
                        }
                    }
                }
            }).build()

            streamDetector!!.setProcessor(streamDetectorProcessor)
            multiDetectorBuilder.add(streamDetector)
            detectorAdded = true
        }

        if(detectorAdded) {
            multiDetector = multiDetectorBuilder.build()
            if(!multiDetector!!.isOperational) {
                cameraCallback!!.onDetectorError()
                return
            }
        }
    }
    
    @SuppressLint("MissingPermission")
    private fun initCamera(camerId: Int, fsp: Float): CameraSource {
        Timber.d("initCamera camerId $camerId")
        Timber.d("initCamera fps $fsp")
        return CameraSource.Builder(context, multiDetector)
                .setRequestedFps(fsp)
                .setAutoFocusEnabled(true)
                .setRequestedPreviewSize(640, 480)
                .setFacing(camerId)
                .build()
    }

    interface OnCompleteListener {
        fun onComplete(byteArray: ByteArray?)
    }

    class ByteArrayTask(context: Context, private val renderScript: RenderScript, private val onCompleteListener: OnCompleteListener) : AsyncTask<Any, Void, ByteArray>() {

        private val contextRef: WeakReference<Context> = WeakReference(context)

        override fun doInBackground(vararg params: kotlin.Any): ByteArray? {
            if (isCancelled) {
                return null
            }
            val byteArray = params[0] as ByteArray
            val width = params[1] as Int
            val height = params[2] as Int
            val orientation = params[3] as Int
            val rotation = params[4] as Float

            val windowService = contextRef.get()!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val currentRotation = windowService.defaultDisplay.rotation
            val nv21Bitmap = Nv21Image.nv21ToBitmap(renderScript, byteArray, width, height)
            var rotate = orientation

            when (currentRotation) {
                Surface.ROTATION_90 -> {
                    rotate -= 90
                }
                Surface.ROTATION_180 -> {
                    rotate -= 180
                }
                Surface.ROTATION_270 -> {
                    rotate -= 270
                }
            }

            rotate %= 360
            rotate += rotation.toInt()

            val matrix = Matrix()
            matrix.postRotate(rotate.toFloat())
            val bitmap =  Bitmap.createBitmap(nv21Bitmap, 0, 0, width, height, matrix, true)
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream)
            val byteArrayOut = stream.toByteArray()
            bitmap.recycle()

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

    companion object {

    }
}