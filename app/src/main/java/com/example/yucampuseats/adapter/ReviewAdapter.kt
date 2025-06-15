package com.example.yucampuseats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.model.Review
import android.net.Uri

class ReviewAdapter(private val reviewList: List<Review>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ratingBar: RatingBar = itemView.findViewById(R.id.itemRatingBar)
        val contentText: TextView = itemView.findViewById(R.id.itemReviewText)
        val imageView: ImageView = itemView.findViewById(R.id.itemReviewImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviewList[position]
        holder.ratingBar.rating = review.rating
        holder.contentText.text = review.commentText ?: ""
        if (review.imageUri != null) {
            holder.imageView.setImageURI(Uri.parse(review.imageUri))
        } else {
            holder.imageView.setImageResource(R.drawable.placeholder_image) // 기본 이미지
        }
    }

    override fun getItemCount(): Int = reviewList.size
}