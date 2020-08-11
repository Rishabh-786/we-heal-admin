package com.weheal.wehealadmin.viewmodel

import androidx.lifecycle.ViewModel
import com.weheal.wehealadmin.repository.Activity2Repository

class Activity2ViewModel : ViewModel() {

    fun onClickbutton2(emaillogin:String ,password:String) {
       Activity2Repository.onclickbutton(emaillogin,password)
    }
}