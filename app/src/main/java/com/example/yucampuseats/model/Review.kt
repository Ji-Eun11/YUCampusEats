package com.example.yucampuseats.model

data class Review(
    val restaurantName: String,
    val menuName: String,
    val rating: Float,
    val commentText: String,
    val imageUri: String?
)