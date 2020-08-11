package com.weheal.wehealadmin.repository


import com.google.firebase.auth.FirebaseAuth


class Activity2Repository {
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    fun onclickbutton(emaillogin : String,password:String){
     firebaseAuth.createUserWithEmailAndPassword(emaillogin,password)

    }
}