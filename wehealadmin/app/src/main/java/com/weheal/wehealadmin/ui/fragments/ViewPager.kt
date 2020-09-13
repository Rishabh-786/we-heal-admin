package com.weheal.wehealadmin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weheal.wehealadmin.R
import com.weheal.wehealadmin.viewPager.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class ViewPager : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentlist = arrayListOf<Fragment>(
            ChatFragment(),
            ContentFragment(),
            NotificationFragment(),
            ProfileFragment()
        )
        val adapter =  ViewPagerAdapter(
            fragmentlist,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        view.viewpager.adapter = adapter

        return view
    }

}