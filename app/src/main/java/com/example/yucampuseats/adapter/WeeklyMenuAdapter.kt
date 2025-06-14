package com.example.yucampuseats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.model.WeeklyMenu
import com.example.yucampuseats.R

class WeeklyMenuAdapter(private val menus: List<WeeklyMenu>) :
    RecyclerView.Adapter<WeeklyMenuAdapter.WeeklyMenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeeklyMenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weekly_menu, parent, false)
        return WeeklyMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeeklyMenuViewHolder, position: Int) {
        val menu = menus[position]
        holder.bind(menu)
    }

    override fun getItemCount(): Int = menus.size

    class WeeklyMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dateText: TextView = itemView.findViewById(R.id.textDate)
        private val restaurantText: TextView = itemView.findViewById(R.id.textRestaurant)
        private val categoryText: TextView = itemView.findViewById(R.id.textCategory)
        private val menuText: TextView = itemView.findViewById(R.id.textMenu)

        fun bind(menu: WeeklyMenu) {
            dateText.text = menu.date
            restaurantText.text = menu.restaurant
            categoryText.text = menu.category
            menuText.text = menu.menu
        }
    }
}