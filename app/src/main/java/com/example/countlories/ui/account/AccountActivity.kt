package com.example.countlories.ui.account

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.countlories.R
import com.example.countlories.databinding.ActivityAccountBinding
import com.example.countlories.ui.camera.CameraActivity
import com.example.countlories.ui.history.HistoryActivity
import com.example.countlories.ui.home.MainActivity
import com.example.countlories.ui.tips.TipsActivity
import com.example.countlories.ui.welcome.WelcomeActivity
import com.example.countlories.utils.factory.ViewModelFactory
import com.example.countlories.viewmodel.profile.ProfileViewModel

class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding
    private lateinit var factory: ViewModelFactory
    private val profileViewModel: ProfileViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupViewModel()
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

    private fun setupViewModel(){
        factory = ViewModelFactory.getInstance(this)

        profileViewModel.getUserData().observe(this){ user ->
            binding.welcomeMsg.text = getString(R.string.greeting, user.name)
            binding.emailUser.text = user.email
        }
    }

    private fun setupAction(){
        bottomNavigation()
        logoutButton()
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

        binding.tipsBtn.setOnClickListener {
            startActivity(Intent(this, TipsActivity::class.java))
            transition()
        }

        binding.scanBtn.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
            transition()
        }
    }

    private fun logoutButton(){
        binding.signOutBtn.setOnClickListener {
            profileViewModel.logout()
            Toast.makeText(this, "Logout Success", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
    }

    private fun transition() {
        overridePendingTransition(R.anim.fade_enter, R.anim.fade_exit)
    }

}