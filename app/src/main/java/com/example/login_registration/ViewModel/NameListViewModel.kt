package com.example.login_registration.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.login_registration.Repository.NameListRepository

class NameListViewModel(private val nameListRepository: NameListRepository): ViewModel() {
    val nameInput = mutableStateOf("")
    val namesList = mutableStateListOf<String>()

    fun displayNameList() {
        nameListRepository.nameList {
            namesList.clear()
            namesList.addAll(it)
        }
    }

    fun addName() {
        val name = nameInput.value.trim()

        if (nameInput.value.isNotEmpty()) {
            nameListRepository.addName(name)
            nameInput.value = ""
        }
    }
}