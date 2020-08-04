package com.weheal.wehealadmin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weheal.wehealadmin.model.Info
import com.weheal.wehealadmin.repository.WeHealRepository

class MainActivityViewModel: ViewModel() {
    private val numberOfOnlineHealers: MutableLiveData<Info> = WeHealRepository.getNumberOfOnlineHealersLiveData()
    val numberOfOnlineHealerLiveData: LiveData<Info> get() = numberOfOnlineHealers
    private val numberOfOnlineUsers:MutableLiveData<Info> = WeHealRepository.getNumberOfOnlineUsersLiveData()
    val numberOfOnlineUsersLiveData: LiveData<Info> get() = numberOfOnlineUsers
    private val numberOfOflineUsers:MutableLiveData<Info> = WeHealRepository.getNumberOfOflneUsersLiveData()
    val numberOfOflineUsersLiveData: LiveData<Info> get() = numberOfOflineUsers
    private val builderName: MutableLiveData<Info> = WeHealRepository.builderNameLiveData()
    val builderNameLiveData: LiveData<Info> = builderName
    fun pushHiThereToDatabase(){
        WeHealRepository.pushHiThereToDatabase()
    }
}