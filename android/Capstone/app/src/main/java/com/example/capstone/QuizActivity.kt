package com.example.capstone

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var optionARadioButton: RadioButton
    private lateinit var optionBRadioButton: RadioButton
    private lateinit var optionCRadioButton: RadioButton
    private lateinit var submitButton: Button
    private lateinit var answerFeedbackTextView: TextView
    private lateinit var questionImageView: ImageView

    private var currentQuestionIndex = 0
    private var isAnswerChecked = false
    private var correctAnswersCount = 0
    private var incorrectAnswersCount = 0

    private val questions = listOf(
        "Huruf Apa ini?",
        "Huruf Apa ini?",
        "Huruf Apa ini?"
    )

    private val options = listOf(
        listOf("A", "B", "C"),
        listOf("Z", "C", "G"),
        listOf("O", "P", "L")
    )

    private val correctAnswers = listOf("A", "G", "L")

    private val questionImages = listOf(
        R.drawable.id_huruf,
        R.drawable.id_hurup,
        R.drawable.id_huruft
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz1)

        // Inisialisasi komponen
        questionTextView = findViewById(R.id.questionTextView)
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup)
        optionARadioButton = findViewById(R.id.optionARadioButton)
        optionBRadioButton = findViewById(R.id.optionBRadioButton)
        optionCRadioButton = findViewById(R.id.optionCRadioButton)
        submitButton = findViewById(R.id.submitButton)
        answerFeedbackTextView = findViewById(R.id.answerFeedbackTextView)
        questionImageView = findViewById(R.id.questionImageView) // Inisialisasi ImageView

        // Set OnClickListener untuk tombol
        submitButton.setOnClickListener {
            submitAnswer()
        }

        // Muat pertanyaan pertama
        loadQuestion()
    }

    // Fungsi untuk memuat pertanyaan dan opsi jawaban
    private fun loadQuestion() {
        if (currentQuestionIndex < questions.size) {
            questionTextView.text = questions[currentQuestionIndex]
            val currentOptions = options[currentQuestionIndex]
            optionARadioButton.text = currentOptions[0]
            optionBRadioButton.text = currentOptions[1]
            optionCRadioButton.text = currentOptions[2]
            questionImageView.setImageResource(questionImages[currentQuestionIndex]) // Set gambar pertanyaan
            optionsRadioGroup.clearCheck()
            answerFeedbackTextView.visibility = View.GONE
            submitButton.text = "cek"
            isAnswerChecked = false
        } else {
            // Jika tidak ada pertanyaan lagi, tampilkan pesan akhir atau lakukan sesuatu
            showResult()
        }
    }

    // Fungsi untuk memeriksa jawaban dan menampilkan feedback
    private fun submitAnswer() {
        if (!isAnswerChecked) {
            val selectedId = optionsRadioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                answerFeedbackTextView.text = "Silakan pilih salah satu jawaban."
                answerFeedbackTextView.visibility = View.VISIBLE
                return
            }

            val selectedRadioButton: RadioButton = findViewById(selectedId)
            val selectedAnswer = selectedRadioButton.text.toString()

            if (selectedAnswer == correctAnswers[currentQuestionIndex]) {
                answerFeedbackTextView.text = "Jawaban benar!"
                answerFeedbackTextView.setTextColor(resources.getColor(android.R.color.holo_green_dark, null))
                correctAnswersCount++
            } else {
                answerFeedbackTextView.text = "Jawaban salah. Jawaban yang benar adalah: ${correctAnswers[currentQuestionIndex]}"
                answerFeedbackTextView.setTextColor(resources.getColor(android.R.color.holo_red_dark, null))
                incorrectAnswersCount++
            }
            answerFeedbackTextView.visibility = View.VISIBLE
            submitButton.text = "lanjutkan"
            isAnswerChecked = true
        } else {
            currentQuestionIndex++
            loadQuestion()
        }
    }

    // Fungsi untuk menampilkan hasil akhir
    private fun showResult() {
        val score = (correctAnswersCount / questions.size.toDouble()) * 100
        questionTextView.text = "Quiz selesai!"
        optionARadioButton.visibility = View.GONE
        optionBRadioButton.visibility = View.GONE
        optionCRadioButton.visibility = View.GONE
        questionImageView.visibility = View.GONE
        submitButton.visibility = View.GONE
        answerFeedbackTextView.text = "Terima kasih telah mengikuti quiz.\nJawaban benar: $correctAnswersCount\nJawaban salah: $incorrectAnswersCount\nNilai: ${"%.1f".format(score)}"
        answerFeedbackTextView.visibility = View.VISIBLE
    }
}
