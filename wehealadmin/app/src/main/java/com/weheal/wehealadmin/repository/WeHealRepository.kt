package com.weheal.wehealadmin.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.weheal.wehealadmin.cache.WeHealCache
import com.weheal.wehealadmin.model.Info
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object WeHealRepository
{

   private val firebaseDatabase: FirebaseDatabase by lazy {
        FirebaseDatabase.getInstance()
    }
    fun builderNameLiveData(): MutableLiveData<Info>{
        var mutableLiveData: MutableLiveData<Info>? = WeHealCache.getBuilderNameLiveData("Name")
        if (mutableLiveData == null){
            mutableLiveData = MutableLiveData()
            WeHealCache.putBuilderNameLiveData("Name" , mutableLiveData)
        }

        firebaseDatabase.reference.child("dummyData/name").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?: "Anonymous"
                    mutableLiveData.value = Info(key , value)

                }
            }
        })

        return mutableLiveData
    }
    fun pushHiThereToDatabase() {
        firebaseDatabase.reference.child("dummyData").child("message").setValue("hi there")
    }
    fun getNumberOfOnlineHealersLiveData(): MutableLiveData<Info> {
        var mutableLiveData: MutableLiveData<Info>? = WeHealCache.getNumberOfOnlineHealersLiveData("onlineHealers")
        if (mutableLiveData == null) {
            mutableLiveData = MutableLiveData()
            WeHealCache.putNumberOfOnlineHealersLiveData("onlineHealers", mutableLiveData)
        }
       // GlobalScope.launch {
//            delay(5000)
//            mutableLiveData.postValue(10)
//        }
        firebaseDatabase.reference.child("dummyData/numberOfOnlineHealers").addValueEventListener(object: ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                   val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"No data available"
                    mutableLiveData.value = Info(key, value) //snapshot.value?.toString()?.toIntOrNull()?:-1
                }
            }

//            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
//
//            }
//
//            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
//                if (snapshot.exists()) {
//                    val key = snapshot.key!!
//                    val value = snapshot.value?.toString()?:"No data available"
//                    mutableLiveData.value = Info(key, value) //snapshot.value?.toString()?.toIntOrNull()?:-1
//                }
//            }
//
//            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
//                val key = snapshot.key!!
//                val value = snapshot.value?.toString() ?: "No data available"
//                mutableLiveData.value = Info(key, value)
//            }
//
//            override fun onChildRemoved(snapshot: DataSnapshot) {
//            val key = snapshot.key!!
//            val value = snapshot.value?.toString() ?: "No data available"
//            mutableLiveData.value = Info(key, value)
//        }
        })
        return mutableLiveData
    }
    fun getNumberOfOnlineUsersLiveData(): MutableLiveData<Info> {
        var mutableLiveData: MutableLiveData<Info>? = WeHealCache.getNumberOfOnlineUsersLiveData("onlineUsers")
        if (mutableLiveData == null) {
            mutableLiveData = MutableLiveData()
             WeHealCache.putNumberOfOnlineUsersLiveData("onlineUsers", mutableLiveData)
        }
//        GlobalScope.launch {
//            delay(5000)
//            mutableLiveData.postValue(20)
//        }
        firebaseDatabase.reference.child("dummyData/numberOfOnlineUsers").addValueEventListener(object: ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"No data available"
                    mutableLiveData.value = Info(key, value) //snapshot.value?.toString()?.toIntOrNull()?:-1
                }
            }

        })

        return mutableLiveData
    }
    fun getNumberOfOflneUsersLiveData(): MutableLiveData<Info> {
        var mutableLiveData: MutableLiveData<Info>? = WeHealCache.getNumberOfOflineUsersLiveData("oflineUsers")
        if (mutableLiveData == null) {
            mutableLiveData = MutableLiveData()
            WeHealCache.putNumberOfOflineUsersLiveData("oflineUsers", mutableLiveData)
        }
//        GlobalScope.launch {
//            delay(5000)
//            mutableLiveData.postValue(5)
//        }
        firebaseDatabase.reference.child("dummyData/numberOfOflineUsers").addValueEventListener(object: ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())
                {
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString()?:"No Data"
                    mutableLiveData.value = Info(key , value)
                }
            }


        })
        return mutableLiveData
    }
}
