package com.weheal.wehealadmin.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

object MainActivity2Repository {
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    fun login(emaillogin : String,password:String){
        firebaseAuth.createUserWithEmailAndPassword(emaillogin,password).addOnCompleteListener() {
                task: Task<AuthResult> ->
            if (task.isSuccessful)
            {

            }
            else
            {

            }

        }


    }
}