package com.weheal.wehealadmin.weHealAdminAuth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.weheal.wehealadmin.weHealAdminSharedPreferences.WeHealAdminSharedPreferences
import com.weheal.wehealadmin.weHealAdminUser.WeHealAdminUser

sealed class WeHealUserResource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T): WeHealUserResource<T>(data)
    class Loading<T>(message: String, data: T? = null): WeHealUserResource<T>(data, message)
    class Request<T>(message: String, data: T? = null): WeHealUserResource<T>(data, message)
    class Error<T>( message: String, data: T? = null): WeHealUserResource<T>(data, message)
}

object WeHealAuth {
    //Firebase related variables
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private  val currentAdminUserMutableLiveData:MutableLiveData<WeHealUserResource<WeHealAdminUser>> = MutableLiveData()
    val currentAdminUserLiveData: LiveData<WeHealUserResource<WeHealAdminUser>> = currentAdminUserMutableLiveData

    private fun setCurrentAdminUser(newWeHealAdminUser: WeHealAdminUser ){
        currentAdminUserMutableLiveData.value=WeHealUserResource.Success(newWeHealAdminUser)
    }
    fun startSignIn() {
        val firebaseUser: FirebaseUser? = firebaseAuth.currentUser
        if (firebaseUser == null) {
         currentAdminUserMutableLiveData.value = WeHealUserResource.Request("")
        }
        else{
            val weHealAdminUser:WeHealAdminUser? = WeHealAdminSharedPreferences.getAdminUser()
            if (weHealAdminUser == null)
            {
                val newWeHealAdminUser = WeHealAdminUser.create(firebaseUser)
                 setCurrentAdminUser(newWeHealAdminUser)
            }
            else{
                setCurrentAdminUser(weHealAdminUser)
            }
        }
    }
}