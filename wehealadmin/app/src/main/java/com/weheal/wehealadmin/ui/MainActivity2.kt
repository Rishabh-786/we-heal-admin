package com.weheal.wehealadmin.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.weheal.wehealadmin.R
import com.weheal.wehealadmin.repository.Activity2Repository
import com.weheal.wehealadmin.viewmodel.Activity2ViewModel
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var activity2ViewModel: Activity2ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        activity2ViewModel = ViewModelProvider(this).get(Activity2ViewModel::class.java)
        button2.setOnClickListener {
            onclick()
        }
    }
    fun onclick()
    {
        var email1 = emaillogin.text.toString()
        var password1 =  password.text.toString()
        if (email1.isEmpty()) {
            emaillogin.setError("please fill the empty box")
            emaillogin.requestFocus()
        }
        if (password1.isEmpty()) {
            password.setError("please fill the empty box")
            password.requestFocus()
        }
        if (email1.isEmpty()&&password1.isEmpty())
        {

        }
        if (!email1.isEmpty()&&!password1.isEmpty())
        {
            activity2ViewModel.onClickbutton2(email1,password1)
        }

    }
}