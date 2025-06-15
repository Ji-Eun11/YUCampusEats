package com.example.yucampuseats.ui

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.yucampuseats.R
import com.example.yucampuseats.model.Review
import com.example.yucampuseats.model.ReviewStorage

class WriteReviewFragment : Fragment(R.layout.fragment_write_review) {

    private lateinit var ratingBar: RatingBar
    private lateinit var editTextReviewContent: EditText
    private lateinit var btnSubmitReview: Button

    private var restaurantName: String = ""
    private var menuName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            restaurantName = it.getString("restaurantName") ?: ""
            menuName = it.getString("menuName") ?: ""
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ratingBar = view.findViewById(R.id.ratingBar)
        editTextReviewContent = view.findViewById(R.id.editTextReviewContent)
        btnSubmitReview = view.findViewById(R.id.btnSubmitReview)

        btnSubmitReview.setOnClickListener {
            val rating = ratingBar.rating
            if (rating == 0f) {
                Toast.makeText(requireContext(), "별점을 선택해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val comment = editTextReviewContent.text.toString()

            try {
                val newReview = Review(
                    restaurantName = restaurantName,
                    menuName = menuName,
                    rating = rating,
                    commentText = comment,
                    imageUri = null
                )
                ReviewStorage.addReview(newReview)

                Toast.makeText(requireContext(), "리뷰가 등록되었습니다.", Toast.LENGTH_SHORT).show()

                parentFragmentManager.popBackStack()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(requireContext(), "리뷰 등록 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance(restaurantName: String, menuName: String) = WriteReviewFragment().apply {
            arguments = Bundle().apply {
                putString("restaurantName", restaurantName)
                putString("menuName", menuName)
            }
        }
    }
}
