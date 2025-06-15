package com.example.yucampuseats.ui

import android.net.Uri
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.model.Review

class ReviewAdapter(private var reviews: List<Review>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restaurantName: TextView = view.findViewById(R.id.textRestaurantName)
        val ratingBar: RatingBar = view.findViewById(R.id.ratingBar)
        val commentText = view.findViewById<TextView>(R.id.textComment)
        val imageView = view.findViewById<ImageView>(R.id.itemReviewImage)
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
        holder.commentText.text = review.commentText
        if (review.imageUri != null) {
            holder.imageView.setImageURI(Uri.parse(review.imageUri))
        } else {
            holder.imageView.setImageResource(R.drawable.placeholder_image)
        }
    }

    fun updateList(newList: List<Review>) {
        reviews = newList
        notifyDataSetChanged()
    }

    override fun getItemCount() = reviews.size
}