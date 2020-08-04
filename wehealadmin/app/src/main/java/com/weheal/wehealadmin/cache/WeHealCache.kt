package com.weheal.wehealadmin.cache

import androidx.lifecycle.MutableLiveData
import com.weheal.wehealadmin.model.Info

object WeHealCache
{
    private val numberOfOnlineHealersCache: HashMap<String, MutableLiveData<Info>> = HashMap()
    fun getNumberOfOnlineHealersLiveData(onlineHealers: String): MutableLiveData<Info>? = numberOfOnlineHealersCache[onlineHealers]
    fun putNumberOfOnlineHealersLiveData(onlineHealers: String, numberOfOnlineHealersLiveData: MutableLiveData<Info>): Boolean {
        numberOfOnlineHealersCache[onlineHealers] = numberOfOnlineHealersLiveData
        return true
    }
    private val numberOfOnlineUsersCache: HashMap<String, MutableLiveData<Info>> = HashMap()
    fun getNumberOfOnlineUsersLiveData(onlineUsers: String): MutableLiveData<Info>? = numberOfOnlineUsersCache[onlineUsers]
    fun putNumberOfOnlineUsersLiveData(onlineUsers: String, numberOfOnlineUsersLiveData: MutableLiveData<Info>): Boolean {
        numberOfOnlineUsersCache[onlineUsers] = numberOfOnlineUsersLiveData
        return true
    }
    private val numberOfOflineUsersCache: HashMap<String, MutableLiveData<Info>> = HashMap()
    fun getNumberOfOflineUsersLiveData(oflineUsers: String): MutableLiveData<Info>? = numberOfOflineUsersCache[oflineUsers]
    fun putNumberOfOflineUsersLiveData(oflineUsers: String, numberOfOflineUsersLiveData: MutableLiveData<Info>): Boolean {
        numberOfOnlineUsersCache[oflineUsers] = numberOfOflineUsersLiveData
        return true
    }
    private val builderNameCache: HashMap<String , MutableLiveData<Info>> = HashMap()
    fun getBuilderNameLiveData(Name:String): MutableLiveData<Info>? = builderNameCache[Name]
    fun putBuilderNameLiveData(Name: String , builderNameLiveData: MutableLiveData<Info>): Boolean{
    builderNameCache[Name] = builderNameLiveData
        return true
}
}