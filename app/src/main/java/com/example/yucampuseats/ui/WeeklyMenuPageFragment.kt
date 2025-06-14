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
import com.example.yucampuseats.databinding.FragmentWeeklyMenuPageBinding
import com.example.yucampuseats.model.WeeklyMenu

// WeeklyMenuPageFragment.kt
class WeeklyMenuPageFragment : Fragment() {

    private lateinit var restaurantName: String
    private lateinit var recyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restaurantName = arguments?.getString(ARG_RESTAURANT_NAME) ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_weekly_menu_page, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewMenus)

        // 메뉴 데이터 불러오기 (예: MenuDataSource에서)
        val menuList = MenuDataSource.getMenusByRestaurant(restaurantName)
        menuAdapter = MenuAdapter(menuList)
        recyclerView.adapter = menuAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    companion object {
        private const val ARG_RESTAURANT_NAME = "restaurant_name"
        fun newInstance(name: String): WeeklyMenuPageFragment {
            val fragment = WeeklyMenuPageFragment()
            val bundle = Bundle()
            bundle.putString(ARG_RESTAURANT_NAME, name)
            fragment.arguments = bundle
            return fragment
        }
    }
}
