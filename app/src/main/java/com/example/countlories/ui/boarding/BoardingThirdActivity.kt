package com.example.countlories.ui.boarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countlories.databinding.ActivityBoardingThirdBinding
import com.example.countlories.ui.welcome.WelcomeActivity

class BoardingThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardingThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardingThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupAction(){
        binding.continueButton.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

        binding.backButton.setOnClickListener {
            startActivity(Intent(this, BoardingSecondActivity::class.java))
        }
    }

}