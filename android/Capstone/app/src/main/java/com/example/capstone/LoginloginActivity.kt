package com.example.capstone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginloginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginlogin)
        enableEdgeToEdge()

        val buttonLogin: Button = findViewById(R.id.login_button)

        buttonLogin.setOnClickListener {
            val intent = Intent(this@LoginloginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
