package com.example.capstone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonRegister: Button = findViewById(R.id.register_button)
        val buttonLogin : TextView = findViewById(R.id.login_link)

        buttonRegister.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginloginActivity::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginloginActivity::class.java)
            startActivity(intent)
        }
    }
}