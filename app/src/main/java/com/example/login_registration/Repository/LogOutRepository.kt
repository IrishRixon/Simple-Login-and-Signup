package com.example.login_registration.Repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LogOutRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun logOut() {
        auth.signOut()
    }
}