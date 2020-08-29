package com.weheal.wehealadmin.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.weheal.wehealadmin.R
import com.weheal.wehealadmin.ui.fragments.ChatFragment
import com.weheal.wehealadmin.ui.fragments.ContentFragment
import com.weheal.wehealadmin.ui.fragments.NotificationFragment
import com.weheal.wehealadmin.ui.fragments.ProfileFragment
import com.weheal.wehealadmin.viewmodel.MainActivityViewModel
import com.weheal.wehealadmin.weHealAdminAuth.WeHealAuth
import com.weheal.wehealadmin.weHealAdminAuth.WeHealUserResource
import com.weheal.wehealadmin.weHealAdminUser.WeHealAdminUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var providers : List<AuthUI.IdpConfig>
    private val MY_REQUEST_CODE:Int = 123
    private val chatFragment = ChatFragment()
    private val contentFragment =ContentFragment()
    private val notificationFragment = NotificationFragment()
    private val profile = ProfileFragment()

    private val mainActivityViewModel : MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel.currentAppAdminUserLiveData.observe(this, Observer {
            when(it){
                is WeHealUserResource.Request->{
                    providers = listOf(AuthUI.IdpConfig.GoogleBuilder().build())
                    showSignInOption()
                }
            }
        })

//        button_sign_out.setOnClickListener {
//            AuthUI.getInstance().signOut(this).addOnCompleteListener {
//                Toast.makeText(this,"Successfull", Toast.LENGTH_SHORT)
//                button_sign_out.isEnabled=false
//                showSignInOption()
//            }
//                .addOnFailureListener {
//                    Toast.makeText(this,"Failed", Toast.LENGTH_SHORT)
//                }
//
//        }


       bnb.setOnNavigationItemSelectedListener {
           when(it.itemId){
               R.id.nav_chat -> {
                   makeCurrentFragment(chatFragment)
                   true
               }
               R.id.nav_content -> {
                   makeCurrentFragment(contentFragment)
                   true
               }
               R.id.nav_notification ->{
                   makeCurrentFragment(notificationFragment)
                   true
               }
               R.id.nav_profile ->{
                   makeCurrentFragment(profile)
                   true
               }
               else -> false
           }
       }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==MY_REQUEST_CODE){
            if (resultCode== Activity.RESULT_OK){
                val user = FirebaseAuth.getInstance().currentUser
                Toast.makeText(this,""+user!!.email,Toast.LENGTH_SHORT).show()
                makeCurrentFragment(chatFragment)
            }
            else{
                Toast.makeText(this,"Please Login first",Toast.LENGTH_SHORT).show()
                showSignInOption()
            }
        }
    }
    fun showSignInOption(){

        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build(),MY_REQUEST_CODE)

    }
    private fun makeCurrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.activity_main,fragment)
            commit()
        }
    }
}