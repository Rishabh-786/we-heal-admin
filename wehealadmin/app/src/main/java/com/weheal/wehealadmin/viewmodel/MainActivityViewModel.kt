package com.weheal.wehealadmin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.weheal.wehealadmin.weHealAdminAuth.WeHealAuth
import com.weheal.wehealadmin.weHealAdminAuth.WeHealUserResource
import com.weheal.wehealadmin.weHealAdminUser.WeHealAdminUser

class MainActivityViewModel:ViewModel (){
    val currentAppAdminUserLiveData:LiveData<WeHealUserResource<WeHealAdminUser>> get() =  WeHealAuth.currentAdminUserLiveData
}