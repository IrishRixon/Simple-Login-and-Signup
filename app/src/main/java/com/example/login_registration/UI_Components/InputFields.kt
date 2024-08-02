package com.example.login_registration.UI_Components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.login_registration.ViewModel.AuthViewModel

object InputFields {
    @Composable
    fun DefaultOutLineTextField(
        placeHolder: String?,
        txt: MutableState<String>,
        passwordVisual: VisualTransformation = VisualTransformation.None,
        modifier: Modifier = Modifier,
        onValueChanged: (String) -> Unit
    ) {

        OutlinedTextField(
            value = txt.value,
            onValueChange = {
                onValueChanged(it)
            },
            textStyle = TextStyle(Color.Black, fontSize = 16.sp, letterSpacing = 1.sp),
            placeholder = { Text(text = placeHolder ?: "") },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFA39D9D),
                focusedBorderColor = Color(0xFF5A5858)
            ),
            visualTransformation = passwordVisual,
            modifier = modifier
        )
    }
}