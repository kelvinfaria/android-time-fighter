package com.kelvinfaria.timefighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelvinfaria.timefighter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tapMeButton.setOnClickListener {
            incrementScore()
        }
    }

    private fun incrementScore() {
        score++
        binding.userScoreTextView.text = getString(R.string.user_score_text, score)
    }
}