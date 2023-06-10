package com.example.countlories.ui.boarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countlories.R
import com.example.countlories.databinding.ActivityBoardingBinding
import com.example.countlories.ui.welcome.WelcomeActivity

class BoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupAction(){
        binding.continueButton.setOnClickListener {
            startActivity(Intent(this, BoardingSecondActivity::class.java))
            this@BoardingActivity.transitionEnter()
            finish()
        }
        binding.skipButton.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
            this@BoardingActivity.transitionEnter()
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
        this.transitionExit()
    }

    private fun transitionEnter(){
        overridePendingTransition(R.anim.slide_enter_left, R.anim.slide_exit_left)
    }

    private fun transitionExit(){
        overridePendingTransition(R.anim.slide_enter_right, R.anim.slide_exit_right)
    }

}