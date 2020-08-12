package com.weheal.wehealadmin.viewmodel

import androidx.lifecycle.ViewModel
import com.weheal.wehealadmin.repository.MainActivity2Repository

class Activity2ViewModel : ViewModel() {

    fun onClickbutton2(emaillogin:String ,password:String) {
       MainActivity2Repository.login(emaillogin,password)
    }
}
