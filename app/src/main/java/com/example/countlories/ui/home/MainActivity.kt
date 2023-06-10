package com.example.countlories.ui.home

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.countlories.R
import com.example.countlories.databinding.ActivityMainBinding
import com.example.countlories.ui.account.AccountActivity
import com.example.countlories.ui.camera.CameraActivity
import com.example.countlories.ui.history.HistoryActivity
import com.example.countlories.ui.ideal_calculator.CalculatorActivity
import com.example.countlories.ui.tips.TipsActivity
import com.example.countlories.utils.Constant

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupAction(){
        bottomNavigation()
    }

    private fun bottomNavigation(){
        binding.tipsBtn.setOnClickListener {
            startActivity(Intent(this, TipsActivity::class.java))
            transition()
        }

        binding.historyBtn.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
            transition()
        }

        binding.accountBtn.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
            transition()
        }

        binding.scanBtn.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
            transition()
        }

        binding.idealBtn.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
            transition()
        }
    }

    private fun transition() {
        overridePendingTransition(R.anim.fade_enter, R.anim.fade_exit)
    }
}