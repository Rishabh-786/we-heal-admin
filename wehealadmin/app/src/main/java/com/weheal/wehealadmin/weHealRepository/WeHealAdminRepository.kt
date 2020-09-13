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
        var date:String = year+"_"+month+"_"+day
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
}