package com.example.countlories.ui.ideal_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.countlories.R
import com.example.countlories.databinding.ActivityCalculatorBinding
import com.example.countlories.ui.home.MainActivity
import com.example.countlories.viewmodel.calculator.CalculatorViewModel

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupViewModel()
        setupAction()
    }

    private fun setupView(){
        supportActionBar?.hide()
    }

    private fun setupViewModel(){
        calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]
    }

    private fun setupAction(){
        binding.backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            transition()
        }

        binding.calculateButton.setOnClickListener {

            val weight = binding.weightEditText.text.toString()
            val height = binding.heightEditText.text.toString()
            val gender = getSelectedGender()

            if (weight.isNotEmpty() && height.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)

                calculatorViewModel.calculateBMI(gender, weight.toDouble(), height.toDouble())

                calculatorViewModel.bodyMassIndex.observe(this){ bmi ->
                    intent.putExtra(ResultActivity.EXTRA_BMI, bmi)
                }

                calculatorViewModel.idealWeight.observe(this){ value ->
                    intent.putExtra(ResultActivity.EXTRA_IDEAL, value)
                }

                intent.putExtra(ResultActivity.EXTRA_WEIGHT, weight)
                intent.putExtra(ResultActivity.EXTRA_HEIGHT, height)
                intent.putExtra(ResultActivity.EXTRA_GENDER, gender)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Masukkan data diri terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getSelectedGender() : String {
        return when(binding.genderSelect.checkedRadioButtonId){
            R.id.male_btn -> "Laki-laki"
            R.id.female_btn -> "Perempuan"
            else -> ""
        }
    }

    private fun transition() {
        overridePendingTransition(R.anim.fade_enter, R.anim.fade_exit)
    }
}