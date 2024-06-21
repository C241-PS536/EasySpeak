package com.example.capstone

import android.Manifest
import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.IOException

class ConvertSignToWordActivity : AppCompatActivity(), SurfaceHolder.Callback {

    private val CAMERA_PERMISSION_CODE = 100
    private lateinit var surfaceView: SurfaceView
    private var camera: Camera? = null
    private var cameraInitialized = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert_sign_to_word)

        surfaceView = findViewById(R.id.surfaceViewCamera)
        val buttonStart: Button = findViewById(R.id.btnStart)
        val buttonStop: Button = findViewById(R.id.btnStop)

        buttonStart.setOnClickListener {
            if (checkCameraPermission()) {
                startCamera()
            } else {
                requestCameraPermission()
            }
        }

        buttonStop.setOnClickListener {
            stopCamera()
        }

        // Add SurfaceHolder callback
        surfaceView.holder.addCallback(this)
    }

    private fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }


    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            CAMERA_PERMISSION_CODE
        )
    }

    private fun startCamera() {
        try {
            camera = Camera.open()
            val holder: SurfaceHolder = surfaceView.holder
            holder.addCallback(this)
            cameraInitialized = true // Set cameraInitialized to true
        } catch (e: Exception) {
            Log.e("CameraDebug", "Error opening camera: ${e.message}")
            Toast.makeText(this, "Failed to open camera", Toast.LENGTH_SHORT).show()
        }
    }

    private fun stopCamera() {
        camera?.apply {
            stopPreview()
            release()
        }
        cameraInitialized = false // Set cameraInitialized to false
        camera = null
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        try {
            camera?.apply {
                setPreviewDisplay(holder)
                startPreview()
                cameraInitialized = true
            }
        } catch (e: IOException) {
            Log.e("CameraDebug", "Error setting camera preview: ${e.message}")
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        if (cameraInitialized) {
            try {
                camera?.apply {
                    stopPreview()
                    setPreviewDisplay(holder)
                    startPreview()
                }
            } catch (e: IOException) {
                Log.e("CameraDebug", "Error starting camera preview: ${e.message}")
            }
        }
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        stopCamera()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCamera()
            } else {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopCamera()
    }
}
