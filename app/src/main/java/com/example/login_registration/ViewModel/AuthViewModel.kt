package com.example.login_registration.ViewModel

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.login_registration.Activities.LogIn.LogInActivity
import com.example.login_registration.Activities.LogOut.LogOutActivity
import com.example.login_registration.Repository.AuthRepository

class AuthViewModel(private var authRepository: AuthRepository) : ViewModel() {
    val email = mutableStateOf("")
    val password = mutableStateOf("")

    fun registerUser() {
        val email = email.value
        val password = password.value

        if (email.isEmpty() || password.isEmpty()) {
            Log.i("Information", "Empty Credentials")
        } else if (password.length < 6) {
            Log.i("Information", "Password length is less than 6")
        } else {
            authRepository.signUpUser(
                email,
                password,
                { Log.i("Information", "User Registered Successfully") },
                { Log.i("Information", "Error: ${it.message}") }
            )
        }
    }

    fun loginUser(finish: () -> Unit) {
        val email = email.value
        val password = password.value

        if (email.isEmpty() || password.isEmpty()) {
            Log.i("Information", "Empty Credentials")
        } else {
            authRepository.loginUser(
                email,
                password,
                {
                    Log.i("Information", "User Logged In Successfully")
                    finish()
                },
                {
                    Log.i("Information", "Error: ${it.message}")
                }
            )
        }

    }

}