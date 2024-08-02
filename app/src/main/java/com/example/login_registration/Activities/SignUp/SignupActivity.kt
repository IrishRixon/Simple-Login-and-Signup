package com.example.login_registration.Activities.SignUp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_registration.Activities.SignUp.ui.theme.LogIn_RegistrationTheme
import com.example.login_registration.Repository.AuthRepository
import com.example.login_registration.UI_Components.Buttons
import com.example.login_registration.UI_Components.InputFields
import com.example.login_registration.ViewModel.AuthViewModel

class SignupActivity : ComponentActivity() {

    private lateinit var authViewModel: AuthViewModel
    private lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        authRepository = AuthRepository()
        authViewModel = AuthViewModel(authRepository);

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
                        onValueChanged = {
                            authViewModel.email.value = it
                        }
                    )

                    Spacer(Modifier.height(16.dp))

                    InputFields.DefaultOutLineTextField(
                        placeHolder = "Password",
                        txt = authViewModel.password,
                        modifier = Modifier.fillMaxWidth(),
                        passwordVisual = PasswordVisualTransformation(),
                        onValueChanged = {
                            authViewModel.password.value = it
                        }
                    )

                    Spacer(Modifier.height(20.dp))

                    Buttons.SignupButton {
                        authViewModel.registerUser()
                    }
                }
            }
        }
    }
}
