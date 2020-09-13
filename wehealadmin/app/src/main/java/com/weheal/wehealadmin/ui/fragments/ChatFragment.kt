package com.weheal.wehealadmin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.weheal.wehealadmin.R
import com.weheal.wehealadmin.viewmodel.ChatFragmentViewModel
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment() {
    private lateinit var chatFragmentViewModel : ChatFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatFragmentViewModel = ViewModelProvider(this).get(ChatFragmentViewModel::class.java)

        cd.setOnDateChangedListener { datePicker, mYear, mMonth, mDay ->
           chatFragmentViewModel.chatData(mDay,mMonth,mYear)
            chatFragmentViewModel.averageWaitingTimeLiveData.observe(viewLifecycleOwner, Observer {
                awt2.text = it.value
            })
        }

    }
}