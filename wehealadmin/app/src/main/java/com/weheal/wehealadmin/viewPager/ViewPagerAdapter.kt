package com.weheal.wehealadmin.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class ViewPagerAdapter(list:ArrayList<Fragment>,fa:FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fa,lifecycle){

    private val fragmentlist:ArrayList<Fragment> = list

    override fun getItemCount(): Int {
        return  fragmentlist.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentlist[position]
    }
}