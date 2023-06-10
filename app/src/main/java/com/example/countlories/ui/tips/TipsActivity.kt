package com.example.countlories.ui.tips

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countlories.R
import com.example.countlories.databinding.ActivityTipsBinding
import com.example.countlories.ui.account.AccountActivity
import com.example.countlories.ui.camera.CameraActivity
import com.example.countlories.ui.history.HistoryActivity
import com.example.countlories.ui.home.MainActivity

class TipsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        transition()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupAction(){
        bottomNavigation()
    }

    private fun bottomNavigation(){
        binding.homeBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
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
    }

    private fun transition() {
        overridePendingTransition(R.anim.fade_enter, R.anim.fade_exit)
    }
}