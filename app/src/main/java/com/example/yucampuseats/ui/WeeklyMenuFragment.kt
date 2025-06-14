package com.example.yucampuseats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yucampuseats.R
import com.example.yucampuseats.databinding.FragmentWeeklyMenuBinding
import com.google.android.material.tabs.TabLayoutMediator

class WeeklyMenuFragment : Fragment() {

    private var _binding: FragmentWeeklyMenuBinding? = null
    private val binding get() = _binding!!

    private val restaurantNames = listOf("학생회관", "인문계 교직원 식당", "자연계 학생식당")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeeklyMenuBinding.inflate(inflater, container, false)

        val adapter = WeeklyMenuPagerAdapter(this, restaurantNames)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = restaurantNames[position]
        }.attach()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}