package com.example.yucampuseats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.data.MenuData
import com.example.yucampuseats.model.WeeklyMenu

class MenuFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        // ✅ XML에 정의된 ID에 맞게 수정
        recyclerView = view.findViewById(R.id.recyclerViewMenus)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // 예시 데이터 로드
        val menus: List<WeeklyMenu> = MenuData.menuList

        menuAdapter = MenuAdapter(menus)
        recyclerView.adapter = menuAdapter

        return view
    }
}