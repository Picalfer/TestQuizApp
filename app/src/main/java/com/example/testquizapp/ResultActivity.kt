package com.example.testquizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testquizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.apply {
            val userName = intent.getStringExtra(Constants.USER_NAME)
            tvName.text = userName
            val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
            val correctQuestions = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

            tvScore.text = getString(R.string.score_text, correctQuestions, totalQuestions)

            btnSubmit.setOnClickListener {
                startActivity(Intent(this@ResultActivity, MainActivity::class.java))
                finish()
            }
        }
    }
}