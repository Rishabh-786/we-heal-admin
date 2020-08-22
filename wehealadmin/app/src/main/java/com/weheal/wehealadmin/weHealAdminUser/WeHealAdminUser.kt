package com.weheal.wehealadmin.weHealAdminUser

import com.google.firebase.auth.FirebaseUser

class WeHealAdminUser private constructor(){
    lateinit var uid: String
    var ct: Long = 0
    var lt: Long = 0
    
    companion object{
        fun create(firebaseUser: FirebaseUser):WeHealAdminUser{
        return WeHealAdminUser().apply {
            uid = firebaseUser.uid
            ct = firebaseUser.metadata!!.creationTimestamp
            lt = firebaseUser.metadata!!.lastSignInTimestamp
        }
    }}

}