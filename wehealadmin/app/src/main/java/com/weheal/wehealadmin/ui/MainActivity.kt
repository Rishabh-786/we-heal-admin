package com.weheal.wehealadmin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.FirebaseDatabase
import com.weheal.wehealadmin.R
import com.weheal.wehealadmin.model.Info
import com.weheal.wehealadmin.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.builderNameLiveData.observe(this, Observer {
            builder_name.text = it.value
        })
        mainActivityViewModel.numberOfOnlineHealerLiveData.observe(this, Observer {
            number_of_online_healer.text = it.value
        })
        mainActivityViewModel.numberOfOnlineUsersLiveData.observe(this, Observer {
            number_of_online_users.text = it.value
        })
        mainActivityViewModel.numberOfOflineUsersLiveData.observe(this, Observer {
            number_of_ofline_users.text = it.value})


        button.setOnClickListener {
            mainActivityViewModel.pushHiThereToDatabase()
        }
    }
}