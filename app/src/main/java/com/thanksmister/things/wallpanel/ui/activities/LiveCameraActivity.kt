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

package com.thanksmister.things.wallpanel.ui.activities

import android.graphics.SurfaceTexture
import android.os.Bundle
import android.widget.Toast
import com.thanksmister.things.wallpanel.R
import com.thanksmister.things.wallpanel.modules.CameraModule
import com.thanksmister.things.wallpanel.persistence.Configuration
import com.thanksmister.things.wallpanel.utils.ScreenUtils
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

import android.view.*



class LiveCameraActivity : DaggerAppCompatActivity() {

    @Inject lateinit var configuration: Configuration

    private var cameraModule: CameraModule? = null

    private val textureView: TextureView by lazy {
        findViewById<TextureView>(R.id.textureView)
    }

    private val screenUtils by lazy {
        ScreenUtils(this@LiveCameraActivity)
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cameratest)

        if (supportActionBar != null) {
            supportActionBar!!.show()
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.title = getString(R.string.title_camera_test)
        }

        window.setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED)

        screenUtils.resetScreenBrightness(false, configuration, window)

        cameraModule = CameraModule(
                this@LiveCameraActivity,
                configuration = configuration,
                callback = object: CameraModule.CallbackListener {
                    override fun onCameraReady() {
                        // camera ready for use
                        setupSurfaceListener()
                    }
                    override fun onCameraException(message: String) {
                        Toast.makeText(this@LiveCameraActivity,getString(R.string.toast_camera_source_error), Toast.LENGTH_LONG).show()
                    }
                })

        cameraModule?.let {
            lifecycle.addObserver(it)
        }
    }

    private fun setupSurfaceListener() {
        textureView.surfaceTextureListener = object :TextureView.SurfaceTextureListener {
            override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {
                // Transform you image captured size according to the surface width and height
            }
            override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
            }
            override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
                return false
            }
            override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
                //open your camera here
                val surfaceTexture = textureView.surfaceTexture
                surfaceTexture.setDefaultBufferSize(textureView.getWidth(), textureView.getHeight())
                cameraModule?.startCameraPreview(surfaceTexture)
            }
        }
        textureView.rotation = configuration.cameraRotate
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}