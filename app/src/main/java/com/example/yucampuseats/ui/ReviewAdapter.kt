package com.example.yucampuseats.ui

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.model.Review

class ReviewAdapter(
    private var reviews: List<Review>
) : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restaurantName: TextView = view.findViewById(R.id.textRestaurantName)
        val ratingBar: RatingBar = view.findViewById(R.id.itemRatingBar)
        val reviewText: TextView = view.findViewById(R.id.itemReviewText)
        val imageView: ImageView = view.findViewById(R.id.itemReviewImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviews[position]
        holder.restaurantName.text = review.restaurantName
        holder.ratingBar.rating = review.rating
        holder.reviewText.text = review.commentText

        if (!review.imageUri.isNullOrEmpty()) {
            holder.imageView.visibility = View.VISIBLE
            holder.imageView.setImageURI(Uri.parse(review.imageUri))
        } else {
            holder.imageView.visibility = View.GONE
        }
    }

    fun updateList(newList: List<Review>) {
        reviews = newList
        notifyDataSetChanged()
    }

    override fun getItemCount() = reviews.size
}