package com.example.countlories.ui.boarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.countlories.R
import com.example.countlories.databinding.ActivityBoardingSecondBinding
import com.example.countlories.databinding.ActivityLoginBinding
import com.example.countlories.ui.welcome.WelcomeActivity

class BoardingSecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardingSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("anim", "boarding 2")
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
            transitionExit()
        }

        binding.continueButton.setOnClickListener {
            startActivity(Intent(this, BoardingThirdActivity::class.java))
            transitionEnter()
        }

        binding.skipButton.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
            transitionEnter()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        transitionExit()
    }

    private fun transitionEnter(){
        overridePendingTransition(R.anim.slide_enter_left, R.anim.slide_exit_left)
    }

    private fun transitionExit(){
        overridePendingTransition(R.anim.slide_enter_right, R.anim.slide_exit_right)
    }
}