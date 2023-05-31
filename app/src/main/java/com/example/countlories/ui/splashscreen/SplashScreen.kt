package com.example.countlories.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countlories.databinding.ActivitySpalshScreenBinding
import com.example.countlories.ui.authentication.RegisterActivity
import com.example.countlories.ui.boarding.BoardingActivity
import com.example.countlories.ui.home.MainActivity
import com.example.countlories.utils.Constant

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySpalshScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpalshScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewSetUp()
        animationSetUp()
    }

    private fun viewSetUp(){
        supportActionBar?.hide()
    }

    private fun animationSetUp() {
        binding.imageView.alpha = 0f
        binding.imageView.animate().setDuration(Constant.SPLASH_DURATION).alpha(1f).withEndAction{
            startActivity(Intent(this, BoardingActivity::class.java))
        }
    }
}