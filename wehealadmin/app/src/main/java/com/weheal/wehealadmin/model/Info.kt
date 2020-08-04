package com.weheal.wehealadmin.model

import com.google.firebase.database.FirebaseDatabase

class Info(val id : String , val value : String ) {

}
//private fun saveName(){
//    val name = Name.text.toString().trim()
//
//    if(name.isEmpty()){
//        Name.error = "Enter a name"
//        return
//    }
//
//    val ref = FirebaseDatabase.getInstance().getReference("profile")
//    val nameid = ref.push().key
//    val na = Info(nameid, name)
//
//    if (nameid != null) {
//        ref.child(nameid).setValue(na).addOnCompleteListener {
//            Toast.makeText(applicationContext, "name saved successfully")
//        }
//    }
//
//}