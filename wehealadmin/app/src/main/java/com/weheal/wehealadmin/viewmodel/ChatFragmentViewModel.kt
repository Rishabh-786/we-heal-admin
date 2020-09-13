package com.weheal.wehealadmin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weheal.wehealadmin.model.Info
import com.weheal.wehealadmin.weHealRepository.WeHealAdminRepository

class ChatFragmentViewModel:ViewModel() {
    private lateinit var averageWaitingTime:MutableLiveData<Info>
    lateinit var averageWaitingTimeLiveData:LiveData<Info>

fun chatData(day:Int,month:Int,year:Int){
    averageWaitingTime = WeHealAdminRepository.averageWaitingTime(day.toString(),month.toString(),year.toString())
    averageWaitingTimeLiveData = averageWaitingTime
}

}