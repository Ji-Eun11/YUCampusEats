package com.example.yucampuseats.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.model.WeeklyMenu

class GroupedMenuAdapter(private val groupedMenuList: Map<String, List<WeeklyMenu>>) :
    RecyclerView.Adapter<GroupedMenuAdapter.GroupViewHolder>() {

    // 월~금 요일 리스트 (데이터 키와 맞게 사용)
    private val daysOfWeek = listOf("월요일", "화요일", "수요일", "목요일", "금요일")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weekly_menu, parent, false)
        return GroupViewHolder(view)
    }

    override fun getItemCount(): Int = daysOfWeek.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val day = daysOfWeek[position]
        val menus = groupedMenuList[day] ?: emptyList()
        holder.bind(day, menus)
    }

    inner class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewDay: TextView = itemView.findViewById(R.id.tvDate)
        private val textViewMenuList: TextView = itemView.findViewById(R.id.tvMenus)

        fun bind(day: String, menus: List<WeeklyMenu>) {
            textViewDay.text = day
            textViewMenuList.text = menus.joinToString("\n") {
                "${it.restaurant}: ${it.menu}"
            }
        }
    }
}
