package com.example.countlories.ui.detail_tips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countlories.databinding.ActivityDetailTipsBinding

class DetailTipsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }
}