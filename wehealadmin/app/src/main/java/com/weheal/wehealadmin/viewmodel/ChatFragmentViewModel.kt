package com.weheal.wehealadmin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weheal.wehealadmin.model.Info
import com.weheal.wehealadmin.weHealRepository.WeHealAdminRepository

class ChatFragmentViewModel:ViewModel() {
    private lateinit var averageWaitingTime:MutableLiveData<Info>
    lateinit var averageWaitingTimeLiveData:LiveData<Info>
    private lateinit var avgDurationOfChat:MutableLiveData<Info>
    lateinit var avgDurationOfChatLiveData:LiveData<Info>
    private lateinit var longestChatSession:MutableLiveData<Info>
    lateinit var longestChatSessionLiveData:LiveData<Info>
    private lateinit var totalChatSessionsCompleted:MutableLiveData<Info>
    lateinit var totalChatSessionsCompletedLiveData:LiveData<Info>
    private lateinit var totalDurationOfChat:MutableLiveData<Info>
    lateinit var totalDurationOfChatLiveData:LiveData<Info>
    private lateinit var totalNumberOfChatRequests:MutableLiveData<Info>
    lateinit var totalNumberOfChatRequestsLiveData:LiveData<Info>
    private lateinit var totalTimeWaitingOfChats:MutableLiveData<Info>
    lateinit var totalTimeWaitingOfChatsLiveData:LiveData<Info>
    private lateinit var uniqueHealeeCount:MutableLiveData<Info>
    lateinit var uniqueHealeeCountLiveData:LiveData<Info>
    private lateinit var uniqueHealerCount:MutableLiveData<Info>
    lateinit var uniqueHealerCountLiveData:LiveData<Info>

fun chatData(day:Int,month:Int,year:Int){
    averageWaitingTime = WeHealAdminRepository.averageWaitingTime(day.toString(),month.toString(),year.toString())
    averageWaitingTimeLiveData = averageWaitingTime
    avgDurationOfChat = WeHealAdminRepository.avgDurationOfChat(day.toString(),month.toString(),year.toString())
    avgDurationOfChatLiveData = avgDurationOfChat
    longestChatSession = WeHealAdminRepository.longestChatSession(day.toString(),month.toString(),year.toString())
    longestChatSessionLiveData = longestChatSession
    totalChatSessionsCompleted = WeHealAdminRepository.totalChatSessionsCompleted(day.toString(),month.toString(),year.toString())
    totalChatSessionsCompletedLiveData = totalChatSessionsCompleted
    totalDurationOfChat = WeHealAdminRepository.totalDurationOfChat(day.toString(),month.toString(),year.toString())
    totalDurationOfChatLiveData = totalDurationOfChat
    totalNumberOfChatRequests = WeHealAdminRepository.totalNumberOfChatRequests(day.toString(),month.toString(),year.toString())
    totalNumberOfChatRequestsLiveData = totalNumberOfChatRequests
    totalTimeWaitingOfChats = WeHealAdminRepository.totalTimeWaitingOfChats(day.toString(),month.toString(),year.toString())
    totalTimeWaitingOfChatsLiveData = totalTimeWaitingOfChats
    uniqueHealeeCount = WeHealAdminRepository.uniqueHealeeCount(day.toString(),month.toString(),year.toString())
    uniqueHealeeCountLiveData = uniqueHealeeCount
    uniqueHealerCount = WeHealAdminRepository.uniqueHealerCount(day.toString(),month.toString(),year.toString())
    uniqueHealerCountLiveData = uniqueHealerCount

}

}