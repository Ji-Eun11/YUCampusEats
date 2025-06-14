package com.example.yucampuseats.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yucampuseats.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yucampuseats.data.MenuDataSource
import com.example.yucampuseats.ui.StudentHallFragment

class StudentHallFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMenus)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val menus = MenuDataSource.getMenusByRestaurant("학생회관 식당")
        recyclerView.adapter = MenuAdapter(menus)

        return view
    }
}