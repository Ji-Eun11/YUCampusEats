package com.example.yucampuseats.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.model.WeeklyMenu

class MenuAdapter(private val menuList: List<WeeklyMenu>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateText: TextView = itemView.findViewById(R.id.textDate)
        val restaurantText: TextView = itemView.findViewById(R.id.textRestaurant)
        val categoryText: TextView = itemView.findViewById(R.id.textCategory)
        val menuText: TextView = itemView.findViewById(R.id.textMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weekly_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = menuList[position]
        holder.dateText.text = menu.date
        holder.restaurantText.text = menu.restaurant
        holder.categoryText.text = menu.category
        holder.menuText.text = menu.menu
    }

    override fun getItemCount(): Int = menuList.size
}