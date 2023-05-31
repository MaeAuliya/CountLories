package com.example.countlories.ui.boarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countlories.databinding.ActivityBoardingSecondBinding
import com.example.countlories.databinding.ActivityLoginBinding
import com.example.countlories.ui.welcome.WelcomeActivity

class BoardingSecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardingSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardingSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupAction(){
        binding.backButton.setOnClickListener {
            startActivity(Intent(this, BoardingActivity::class.java))
        }

        binding.continueButton.setOnClickListener {
            startActivity(Intent(this, BoardingThirdActivity::class.java))
        }

        binding.skipButton.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
    }
}