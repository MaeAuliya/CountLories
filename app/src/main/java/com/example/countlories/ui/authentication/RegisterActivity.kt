package com.example.countlories.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.countlories.data.model.DataDummy
import com.example.countlories.data.model.UserModel
import com.example.countlories.databinding.ActivityRegisterBinding
import kotlin.math.log

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val list = ArrayList<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupAction(){
        binding.registerButton.setOnClickListener {

            val name = binding.usernameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            addData(name, email, password)

            startActivity(Intent(this, LoginActivity::class.java))
        }
    }



    private fun addData(username:String, email:String, password:String) {
        val data = UserModel(
            username,
            email,
            password
        )

        list.add(data)
        Log.d("Data", list.toString())
    }

}