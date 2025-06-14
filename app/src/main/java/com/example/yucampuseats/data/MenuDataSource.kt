package com.example.yucampuseats.data

import com.example.yucampuseats.model.WeeklyMenu

object MenuDataSource {

    fun getMenusByRestaurant(restaurantName: String): List<WeeklyMenu> {
        return MenuData.menuList.filter { it.restaurant == restaurantName }
    }
}