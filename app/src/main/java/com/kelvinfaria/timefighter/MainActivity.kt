package com.kelvinfaria.timefighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.kelvinfaria.timefighter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var score = 0
    private var gameStarted = false
    private lateinit var countDownTimer: CountDownTimer
    private val initialCountDown: Long = 60000
    private val countDownInterval: Long = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tapMeButton.setOnClickListener {
            incrementScore()
        }

        resetGame()
    }

    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }

    private fun resetGame() {
        score = 0

        binding.userScoreTextView.text = getString(R.string.user_score_text, score)

        val initialTimeLeft = initialCountDown / 1000
        binding.timeLeftTextView.text = getString(R.string.time_left_text, initialTimeLeft)

        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                binding.timeLeftTextView.text = getString(R.string.time_left_text, timeLeft)
            }

            override fun onFinish() {
                endGame() 
            }
        }

        gameStarted = false
    }

    private fun endGame() {
        Toast.makeText(this, getString(R.string.game_over_text, score), Toast.LENGTH_LONG).show()
        resetGame()
    }

    private fun incrementScore() {
        if (!gameStarted) {
            startGame()
        }
        score++
        binding.userScoreTextView.text = getString(R.string.user_score_text, score)
    }
}