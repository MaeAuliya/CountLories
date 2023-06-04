package com.example.countlories.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.countlories.data.model.DataDummy
import com.example.countlories.data.model.UserModel
import com.example.countlories.databinding.ActivityLoginBinding
import com.example.countlories.ui.home.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var list = ArrayList<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupData()
        setupAction()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupAction(){
        binding.loginButton.setOnClickListener {

            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()



            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun setupData(){
        val data = DataDummy.getDummyUserData()
        list.addAll(data)

        Log.d("Data", list.toString())
    }

}