package com.example.yucampuseats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.data.MenuDataSource

class HumanitiesStaffFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMenus)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // "인문계 교직원 식당" 메뉴만 가져오기
        val menus = MenuDataSource.getMenusByRestaurant("인문계 교직원 식당")
        recyclerView.adapter = MenuAdapter(menus)

        return view
    }
}