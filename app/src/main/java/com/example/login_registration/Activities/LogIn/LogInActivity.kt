package com.example.login_registration.Activities.LogIn

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login_registration.Activities.LogIn.ui.theme.LogIn_RegistrationTheme
import com.example.login_registration.UI_Components.InputFields
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.login_registration.Activities.LogOut.LogOutActivity
import com.example.login_registration.Repository.AuthRepository
import com.example.login_registration.UI_Components.Buttons
import com.example.login_registration.ViewModel.AuthViewModel

class LogInActivity : ComponentActivity() {

    private lateinit var authRepository: AuthRepository
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        authRepository = AuthRepository()
        authViewModel = AuthViewModel(authRepository)
        val context = this

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LogIn_RegistrationTheme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    InputFields.DefaultOutLineTextField(
                        placeHolder = "Email",
                        txt = authViewModel.email,
                        modifier = Modifier.fillMaxWidth(),
                        onValueChanged = { authViewModel.email.value = it }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    InputFields.DefaultOutLineTextField(
                        placeHolder = "Password",
                        txt = authViewModel.password,
                        modifier = Modifier.fillMaxWidth(),
                        passwordVisual = PasswordVisualTransformation(),
                        onValueChanged = { authViewModel.password.value = it }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Buttons.LoginButton {
                        authViewModel.loginUser {
                            Intent(context, LogOutActivity::class.java). also {
                                context.startActivity(it)
                                finish()
                            }
                        }
                    }
                }
            }
        }
    }
}

