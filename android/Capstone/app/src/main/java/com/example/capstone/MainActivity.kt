package com.example.capstone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonConvertSignToWord: Button = findViewById(R.id.button_convert_sign_to_word)
        val buttonQuiz: Button = findViewById(R.id.button_quiz)

        buttonConvertSignToWord.setOnClickListener {
            val intent = Intent(this@MainActivity, ConvertSignToWordActivity::class.java)
            startActivity(intent)
        }

        buttonQuiz.setOnClickListener {
            val intent = Intent(this@MainActivity, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}
