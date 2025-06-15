package com.example.yucampuseats.model

object ReviewStorage {
    private val reviewList = mutableListOf<Review>()

    fun addReview(review: Review) {
        reviewList.add(review)
    }

    fun getAllReviews(): List<Review> = reviewList.toList()
}
