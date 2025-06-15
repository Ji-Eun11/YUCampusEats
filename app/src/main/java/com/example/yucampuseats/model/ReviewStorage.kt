package com.example.yucampuseats.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ReviewStorage {
    private const val PREFS_NAME = "review_prefs"
    private const val KEY_REVIEWS = "key_reviews"

    private var reviewList: MutableList<Review> = mutableListOf()
    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context.applicationContext
        loadReviews()
    }

    private fun loadReviews() {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_REVIEWS, null)
        if (json != null) {
            val type = object : TypeToken<MutableList<Review>>() {}.type
            reviewList = Gson().fromJson(json, type)
        }
    }

    private fun saveReviews() {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_REVIEWS, Gson().toJson(reviewList)).apply()
    }

    fun getAllReviews(): List<Review> = reviewList.toList()

    fun addReview(review: Review) {
        reviewList.add(review)
        saveReviews()
    }
}