package com.example.login_registration.Activities.LogOut

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_registration.Activities.LogOut.ui.theme.LogIn_RegistrationTheme
import com.example.login_registration.Activities.MainActivity
import com.example.login_registration.Repository.LogOutRepository
import com.example.login_registration.Repository.NameListRepository
import com.example.login_registration.UI_Components.Buttons
import com.example.login_registration.UI_Components.InputFields
import com.example.login_registration.ViewModel.LogOutViewModel
import com.example.login_registration.ViewModel.NameListViewModel

class LogOutActivity : ComponentActivity() {

    private lateinit var logOutRepository: LogOutRepository
    private lateinit var logOutViewModel: LogOutViewModel
    private lateinit var nameListRepository: NameListRepository
    private lateinit var nameListViewModel: NameListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        logOutRepository = LogOutRepository()
        logOutViewModel = LogOutViewModel(logOutRepository)
        nameListRepository = NameListRepository()
        nameListViewModel = NameListViewModel(nameListRepository)

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
                    Column(
                        modifier = Modifier.weight(0.1f)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            InputFields.DefaultOutLineTextField(
                                placeHolder = "Name",
                                txt = nameListViewModel.nameInput,
                                onValueChanged = {
                                    nameListViewModel.nameInput.value = it
                                },
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(Modifier.width(8.dp))
                            Buttons.AddNameButton {
                                nameListViewModel.addName()
                            }
                        }
                    }

                    Column(
                        modifier = Modifier.weight(0.8f)
                    ) {
                        LaunchedEffect(key1 = Unit) {
                            nameListViewModel.displayNameList()
                            Log.i("Information", "${nameListViewModel.namesList}")
                        }
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Log.i("Information", "Lazy Column Recompose")
                            items(nameListViewModel.namesList) {
                                Text(
                                    text = it,
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                )

                                Divider(thickness = 1.dp)
                            }
                        }
                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                    ) {
                        Buttons.LogoutButton {
                            logOutViewModel.logOut{
                                intent()
                            }
                        }
                    }
                }
            }
        }
    }
    private fun intent() {
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}

