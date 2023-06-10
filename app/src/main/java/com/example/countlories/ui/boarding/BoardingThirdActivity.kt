package com.example.countlories.ui.boarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.countlories.R
import com.example.countlories.databinding.ActivityBoardingThirdBinding
import com.example.countlories.ui.welcome.WelcomeActivity
import com.example.countlories.utils.factory.ViewModelFactory
import com.example.countlories.viewmodel.main.MainViewModel

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
            transitionEnter()
            finish()
        }

        binding.backButton.setOnClickListener {
            startActivity(Intent(this, BoardingSecondActivity::class.java))
            transitionExit()
            finish()
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