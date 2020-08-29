package com.weheal.wehealadmin.myApplication

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.weheal.wehealadmin.ui.fragments.ProfileFragment
import com.weheal.wehealadmin.weHealAdminAuth.WeHealAuth
import com.weheal.wehealadmin.weHealAdminSharedPreferences.WeHealAdminSharedPreferences

class MyApplication:Application() {
    override fun onCreate() {
        Log.d("WeHealAuth","My Application")
        super.onCreate()
        WeHealAdminSharedPreferences.connect(applicationContext)
        WeHealAuth.startSignIn() 
    }
}