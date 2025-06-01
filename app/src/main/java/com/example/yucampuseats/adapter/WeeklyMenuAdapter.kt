package com.example.yucampuseats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.model.WeeklyMenu

class WeeklyMenuAdapter(private val items: List<WeeklyMenu>) :
    RecyclerView.Adapter<WeeklyMenuAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.textDate)
        val category: TextView = view.findViewById(R.id.textCategory)
        val menu: TextView = view.findViewById(R.id.textMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weekly_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.date.text = "${item.date} (${item.mealTime})"
        holder.category.text = item.category
        holder.menu.text = item.menu
    }

    override fun getItemCount() = items.size
}
