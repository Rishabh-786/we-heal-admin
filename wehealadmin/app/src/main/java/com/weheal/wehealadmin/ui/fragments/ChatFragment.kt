package com.weheal.wehealadmin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
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
            val month = mMonth+1
            Toast.makeText(activity,"Date Selected :- $mDay/$month/$mYear",Toast.LENGTH_LONG).show()
           chatFragmentViewModel.chatData(mDay,mMonth+1,mYear)
            awt1.visibility = View.VISIBLE
            awt2.visibility = View.VISIBLE
            adc1.visibility = View.VISIBLE
            adc2.visibility = View.VISIBLE
            lcs1.visibility = View.VISIBLE
            lcs2.visibility = View.VISIBLE
            tcs1.visibility = View.VISIBLE
            tcs2.visibility = View.VISIBLE
            tdc1.visibility = View.VISIBLE
            tdc2.visibility = View.VISIBLE
            tncr1.visibility = View.VISIBLE
            tncr2.visibility = View.VISIBLE
            twc1.visibility = View.VISIBLE
            twc2.visibility = View.VISIBLE
            uhc1.visibility = View.VISIBLE
            uhc2.visibility = View.VISIBLE
            uhrc1.visibility = View.VISIBLE
            uhrc2.visibility = View.VISIBLE
             chatFragmentViewModel.averageWaitingTimeLiveData.observe(viewLifecycleOwner, Observer {
                awt2.text = it.value
            })
            chatFragmentViewModel.avgDurationOfChatLiveData.observe(viewLifecycleOwner, Observer {
                adc2.text = it.value
            })
            chatFragmentViewModel.longestChatSessionLiveData.observe(viewLifecycleOwner, Observer {
                lcs2.text = it.value
            })
            chatFragmentViewModel.totalChatSessionsCompletedLiveData.observe(viewLifecycleOwner, Observer {
                tcs2.text = it.value
            })
            chatFragmentViewModel.totalDurationOfChatLiveData.observe(viewLifecycleOwner, Observer {
                tdc2.text = it.value
            })
            chatFragmentViewModel.totalNumberOfChatRequestsLiveData.observe(viewLifecycleOwner, Observer {
                tncr2.text = it.value
            })
            chatFragmentViewModel.totalTimeWaitingOfChatsLiveData.observe(viewLifecycleOwner, Observer {
                twc2.text = it.value
            })
            chatFragmentViewModel.uniqueHealeeCountLiveData.observe(viewLifecycleOwner, Observer {
                uhc2.text = it.value
            })
            chatFragmentViewModel.uniqueHealerCountLiveData.observe(viewLifecycleOwner, Observer {
                uhrc2.text = it.value
            })

        }

    }
}