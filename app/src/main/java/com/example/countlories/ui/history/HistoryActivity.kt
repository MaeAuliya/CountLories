package com.example.countlories.ui.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countlories.adapter.MenuAdapter
import com.example.countlories.data.model.DataDummy
import com.example.countlories.data.model.MenuModel
import com.example.countlories.databinding.ActivityHistoryBinding
import com.example.countlories.ui.account.AccountActivity
import com.example.countlories.ui.home.MainActivity
import com.example.countlories.ui.tips.TipsActivity

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private val listMenu = ArrayList<MenuModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
        setupData()
        getData()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupAction(){
        bottomNavigation()
    }

    private fun setupData(){
        val data = DataDummy.generateMenuData()
        listMenu.addAll(data)
    }

    private fun getData(){
        binding.rvHistory.layoutManager = LinearLayoutManager(this)
        val adapter = MenuAdapter(listMenu)
        binding.rvHistory.adapter = adapter
    }

    private fun bottomNavigation(){
        binding.tipsBtn.setOnClickListener {
            startActivity(Intent(this, TipsActivity::class.java))
        }

        binding.homeBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.accountBtn.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }
    }
}