package com.weheal.wehealadmin.weHealRepository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.weheal.wehealadmin.model.Info

object WeHealAdminRepository {
    private val firebaseDatabase: FirebaseDatabase by lazy {
        FirebaseDatabase.getInstance()
    }
    fun averageWaitingTime(day:String,month:String,year:String):MutableLiveData<Info>{
        var mutableLiveData:MutableLiveData<Info>? = MutableLiveData()
        if (mutableLiveData==null)
        {
          mutableLiveData = MutableLiveData()
        }
        val date:String = year+"_"+month+"_"+day
        firebaseDatabase.reference.child("timesamptWiseHealingSessionCumulativeStats").child(date).child("DTD/averageWaitingTime").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"Not Available"
                    mutableLiveData.value = Info( key , value)
                    Log.d("WeHealAdminRepository","Average Waiting Time")
                }

            }

        })
        return mutableLiveData

    }
    fun avgDurationOfChat(day:String,month:String,year:String):MutableLiveData<Info>{
        var mutableLiveData:MutableLiveData<Info>? = MutableLiveData()
        if (mutableLiveData==null)
        {
            mutableLiveData = MutableLiveData()
        }
        val date:String = year+"_"+month+"_"+day
        firebaseDatabase.reference.child("timesamptWiseHealingSessionCumulativeStats").child(date).child("DTD/avgDurationOfChat").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"Not Available"
                    mutableLiveData.value = Info( key , value)
                    Log.d("WeHealAdminRepository","avgDurationOfChat")
                }

            }

        })
        return mutableLiveData

    }
    fun longestChatSession(day:String,month:String,year:String):MutableLiveData<Info>{
        var mutableLiveData:MutableLiveData<Info>? = MutableLiveData()
        if (mutableLiveData==null)
        {
            mutableLiveData = MutableLiveData()
        }
        val date:String = year+"_"+month+"_"+day
        firebaseDatabase.reference.child("timesamptWiseHealingSessionCumulativeStats").child(date).child("DTD/longestChatSession").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"Not Available"
                    mutableLiveData.value = Info( key , value)
                    Log.d("WeHealAdminRepository","longestChatSession")
                }

            }

        })
        return mutableLiveData

    }
    fun totalChatSessionsCompleted(day:String,month:String,year:String):MutableLiveData<Info>{
        var mutableLiveData:MutableLiveData<Info>? = MutableLiveData()
        if (mutableLiveData==null)
        {
            mutableLiveData = MutableLiveData()
        }
        val date:String = year+"_"+month+"_"+day
        firebaseDatabase.reference.child("timesamptWiseHealingSessionCumulativeStats").child(date).child("DTD/totalChatSessionsCompleted").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"Not Available"
                    mutableLiveData.value = Info( key , value)
                    Log.d("WeHealAdminRepository","totalChatSessionsCompleted")
                }

            }

        })
        return mutableLiveData

    }
    fun totalDurationOfChat(day:String,month:String,year:String):MutableLiveData<Info>{
        var mutableLiveData:MutableLiveData<Info>? = MutableLiveData()
        if (mutableLiveData==null)
        {
            mutableLiveData = MutableLiveData()
        }
        val date:String = year+"_"+month+"_"+day
        firebaseDatabase.reference.child("timesamptWiseHealingSessionCumulativeStats").child(date).child("DTD/totalDurationOfChat").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"Not Available"
                    mutableLiveData.value = Info( key , value)
                    Log.d("WeHealAdminRepository","totalDurationOfChat")
                }

            }

        })
        return mutableLiveData

    }
    fun totalNumberOfChatRequests(day:String,month:String,year:String):MutableLiveData<Info>{
        var mutableLiveData:MutableLiveData<Info>? = MutableLiveData()
        if (mutableLiveData==null)
        {
            mutableLiveData = MutableLiveData()
        }
        val date:String = year+"_"+month+"_"+day
        firebaseDatabase.reference.child("timesamptWiseHealingSessionCumulativeStats").child(date).child("DTD/totalNumberOfChatRequests").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"Not Available"
                    mutableLiveData.value = Info( key , value)
                    Log.d("WeHealAdminRepository","totalNumberOfChatRequests")
                }

            }

        })
        return mutableLiveData

    }
    fun totalTimeWaitingOfChats(day:String,month:String,year:String):MutableLiveData<Info>{
        var mutableLiveData:MutableLiveData<Info>? = MutableLiveData()
        if (mutableLiveData==null)
        {
            mutableLiveData = MutableLiveData()
        }
        val date:String = year+"_"+month+"_"+day
        firebaseDatabase.reference.child("timesamptWiseHealingSessionCumulativeStats").child(date).child("DTD/totalTimeWaitingOfChats").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"Not Available"
                    mutableLiveData.value = Info( key , value)
                    Log.d("WeHealAdminRepository","totalTimeWaitingOfChats")
                }

            }

        })
        return mutableLiveData

    }
    fun uniqueHealeeCount(day:String,month:String,year:String):MutableLiveData<Info>{
        var mutableLiveData:MutableLiveData<Info>? = MutableLiveData()
        if (mutableLiveData==null)
        {
            mutableLiveData = MutableLiveData()
        }
        val date:String = year+"_"+month+"_"+day
        firebaseDatabase.reference.child("timesamptWiseHealingSessionCumulativeStats").child(date).child("DTD/uniqueHealeeCount").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"Not Available"
                    mutableLiveData.value = Info( key , value)
                    Log.d("WeHealAdminRepository","uniqueHealeeCount")
                }

            }

        })
        return mutableLiveData

    }
    fun uniqueHealerCount(day:String,month:String,year:String):MutableLiveData<Info>{
        var mutableLiveData:MutableLiveData<Info>? = MutableLiveData()
        if (mutableLiveData==null)
        {
            mutableLiveData = MutableLiveData()
        }
        val date:String = year+"_"+month+"_"+day
        firebaseDatabase.reference.child("timesamptWiseHealingSessionCumulativeStats").child(date).child("DTD/uniqueHealerCount").addValueEventListener(object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"Not Available"
                    mutableLiveData.value = Info( key , value)
                    Log.d("WeHealAdminRepository","uniqueHealerCount")
                }

            }

        })
        return mutableLiveData

    }

}