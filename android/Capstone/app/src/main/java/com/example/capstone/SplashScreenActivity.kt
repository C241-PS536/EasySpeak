package com.example.capstone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Delay for 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Move to LoginActivity
            val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)
            finish() // Optional: Close SplashScreenActivity
        }, 3000) // 3000 milliseconds = 3 seconds
    }
}
