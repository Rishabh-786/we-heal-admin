package com.weheal.wehealadmin.weHealAdminSharedPreferences

import android.content.Context
import com.google.gson.Gson
import com.weheal.wehealadmin.weHealAdminUser.WeHealAdminUser

object WeHealAdminSharedPreferences {

    private lateinit var applicationContext: Context

    fun connect(applicationContext: Context) {
        this.applicationContext = applicationContext
    }

    fun setWeHealUser(weHealUser: WeHealAdminUser) {
        val sharedPreferences = applicationContext.getSharedPreferences("WeHealAdmin", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(weHealUser)
        editor.putString("weHealAdminUser", json)
        return editor.apply()
    } 

    fun getAdminUser(): WeHealAdminUser? {
        val sharedPreferences = applicationContext.getSharedPreferences("WeHealAdmin", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("weHealAdminUser",null )
         return gson.fromJson(json, WeHealAdminUser::class.java)
    }
}