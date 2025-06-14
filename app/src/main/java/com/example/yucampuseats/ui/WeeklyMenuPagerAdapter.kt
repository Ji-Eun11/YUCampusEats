package com.example.yucampuseats.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class WeeklyMenuPagerAdapter(
    fragment: Fragment,
    private val restaurantNames: List<String>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = restaurantNames.size

    override fun createFragment(position: Int): Fragment {
        return WeeklyMenuPageFragment.newInstance(restaurantNames[position])
    }
}