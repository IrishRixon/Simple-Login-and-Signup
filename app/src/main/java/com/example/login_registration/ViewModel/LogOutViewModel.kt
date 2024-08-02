package com.example.login_registration.ViewModel

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.login_registration.Activities.MainActivity
import com.example.login_registration.Repository.LogOutRepository

class LogOutViewModel(private val logOutRepository: LogOutRepository): ViewModel() {
    fun logOut(intent: () -> Unit) {
        logOutRepository.logOut()
        intent()
    }
}