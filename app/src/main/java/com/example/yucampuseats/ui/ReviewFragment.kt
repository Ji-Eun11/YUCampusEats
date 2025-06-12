package com.example.yucampuseats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yucampuseats.databinding.FragmentReviewBinding
import com.example.yucampuseats.model.Review

class ReviewFragment : Fragment() {

    private var _binding: FragmentReviewBinding? = null
    private val binding get() = _binding!!

    // 임시 저장소(실제로는 DB 또는 서버에 저장)
    private val reviewList = mutableListOf<Review>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmitReview.setOnClickListener {
            val userName = binding.etUserName.text.toString().trim()
            val comment = binding.etReview.text.toString().trim()
            val rating = binding.ratingBar.rating

            if (userName.isEmpty() || comment.isEmpty()) {
                Toast.makeText(requireContext(), "이름과 후기를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val review = Review(userName, rating, comment)
            reviewList.add(review)

            Toast.makeText(requireContext(), "리뷰가 등록되었습니다.", Toast.LENGTH_SHORT).show()

// 입력창 초기화
            binding.etUserName.text.clear()
            binding.etReview.text.clear()
            binding.ratingBar.rating = 0f
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
