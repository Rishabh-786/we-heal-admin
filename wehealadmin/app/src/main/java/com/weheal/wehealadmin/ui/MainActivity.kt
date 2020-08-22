package com.weheal.wehealadmin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.weheal.wehealadmin.R
import com.weheal.wehealadmin.viewmodel.MainActivityViewModel
import com.weheal.wehealadmin.weHealAdminAuth.WeHealAuth
import com.weheal.wehealadmin.weHealAdminAuth.WeHealUserResource
import com.weheal.wehealadmin.weHealAdminUser.WeHealAdminUser

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel : MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel.currentAppAdminUserLiveData.observe(this, Observer {
            when(it){
                is WeHealUserResource.Request->{
                    Toast.makeText(this,"Successfull",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}