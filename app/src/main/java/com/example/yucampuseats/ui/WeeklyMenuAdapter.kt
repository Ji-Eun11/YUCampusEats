package com.example.yucampuseats.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.model.WeeklyMenu

class WeeklyMenuAdapter(private val menuList: List<WeeklyMenu>) :
    RecyclerView.Adapter<WeeklyMenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textDate: TextView = itemView.findViewById(R.id.textDate)
        val textRestaurant: TextView = itemView.findViewById(R.id.textRestaurant)
        val textCategory: TextView = itemView.findViewById(R.id.textCategory)
        val textMenu: TextView = itemView.findViewById(R.id.textMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weekly_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menuList[position]
        holder.textDate.text = item.date
        holder.textRestaurant.text = item.restaurant
        holder.textCategory.text = item.category
        holder.textMenu.text = item.menu
    }

    override fun getItemCount(): Int = menuList.size
}