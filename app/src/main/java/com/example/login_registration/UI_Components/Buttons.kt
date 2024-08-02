package com.example.login_registration.UI_Components

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_registration.Activities.LogIn.LogInActivity

object Buttons {

    @Composable
    fun DefaultButton(
        txt: String,
        modifier: Modifier = Modifier,
        containerColor: Color,
        contentColor: Color,
        padding: PaddingValues = PaddingValues(16.dp),
        fontSize: TextUnit = 16.sp,
        onClicked: () -> Unit
    ) {
        Button(
            onClick = {
                onClicked()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
            contentPadding = padding,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier
        ) {
            Text(text = txt, fontSize = fontSize)
        }
    }

    @Composable
    fun LoginButton(onClicked: () -> Unit) {
        DefaultButton(
            txt = "Log In",
            modifier = Modifier
                .fillMaxWidth(),
            containerColor = Color(0xFF4949F8),
            contentColor = Color(0xFFFFFFFF)
        ) {
            onClicked()
        }
    }

    @Composable
    fun SignupButton(onClicked: () -> Unit) {
        DefaultButton(
            txt = "Sign Up",
            modifier = Modifier
                .fillMaxWidth(),
            containerColor = Color(0xFF39B81C),
            contentColor = Color(0xFFFFFFFF)
        ) {
            onClicked()
        }
    }

    @Composable
    fun AddNameButton(onClicked: () -> Unit) {
        DefaultButton(
            txt = "Add",
            containerColor = Color(0xFF1818AC),
            contentColor = Color(0xFFFFFFFF),
            padding = PaddingValues(10.dp),
            fontSize = 15.sp,
            modifier = Modifier
        ) {
            onClicked()
        }
    }

    @Composable
    fun LogoutButton(onClicked: () -> Unit) {
        DefaultButton(
            txt = "Log out",
            modifier = Modifier
                .fillMaxWidth(),
            containerColor = Color(0xFFB9B9C4),
            contentColor = Color(0xFFFFFFFF)
        ) {
            onClicked()
        }
    }
}