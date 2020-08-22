package com.weheal.wehealadmin.myApplication

import android.app.Application
import com.google.firebase.FirebaseApp
import com.weheal.wehealadmin.weHealAdminAuth.WeHealAuth

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
         WeHealAuth.startSignIn()
    }
}