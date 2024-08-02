package com.example.login_registration.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_registration.Activities.LogIn.LogInActivity
import com.example.login_registration.Activities.SignUp.SignupActivity
import com.example.login_registration.UI_Components.Buttons
import com.example.login_registration.UI_Components.InputFields
import com.example.login_registration.ui.theme.LogIn_RegistrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
                    Buttons.LoginButton {
                        Intent(context, LogInActivity::class.java).also {
                            startActivity(it)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Buttons.SignupButton {
                        Intent(context, SignupActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                }
            }
        }
    }
}
