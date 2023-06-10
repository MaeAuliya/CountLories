package com.example.countlories.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countlories.data.model.BoardingModel
import com.example.countlories.data.model.UserModel
import com.example.countlories.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel (private val repository: Repository) : ViewModel() {

    fun getUserData() : LiveData<UserModel> {
        return repository.getUser()
    }

}