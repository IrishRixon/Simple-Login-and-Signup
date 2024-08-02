package com.example.login_registration.Repository

import android.util.Log
import com.example.login_registration.ViewModel.NameListViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class NameListRepository {
    private val databaseRef = FirebaseDatabase.getInstance()
        .getReference().child("Names")

    fun nameList(onDataChange: (List<String>) -> Unit) {
        val valueEventListener = object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val namesList = mutableListOf<String>()
                if(snapshot.exists()) {
                    for(child in snapshot.children) {
                        for(grandChild in child.children) {
                            val key = grandChild.key
                            val value = grandChild.value
                            val txt = "$key : $value"
                            namesList.add(txt)
                        }
                    }
                }
                onDataChange(namesList)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("Information", "Failed: $error")
            }

        }
        databaseRef.addValueEventListener(valueEventListener)
    }

    fun addName(name: String) {
        databaseRef.push().child("Name").setValue(name)
    }
}