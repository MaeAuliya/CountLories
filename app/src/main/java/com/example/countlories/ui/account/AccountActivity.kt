package com.example.countlories.ui.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countlories.databinding.ActivityAccountBinding
import com.example.countlories.ui.history.HistoryActivity
import com.example.countlories.ui.home.MainActivity
import com.example.countlories.ui.tips.TipsActivity

class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
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
        }

        binding.historyBtn.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.tipsBtn.setOnClickListener {
            startActivity(Intent(this, TipsActivity::class.java))
        }
    }

}