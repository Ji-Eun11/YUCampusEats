package com.example.yucampuseats.ui

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.model.Review
import com.example.yucampuseats.model.ReviewStorage

class ReviewFragment : Fragment(R.layout.fragment_review) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReviewAdapter
    private lateinit var btnWriteReview: Button

    // 식당 및 메뉴 이름 설정 (임시값, 실제 앱에선 인텐트나 번들로 전달받기)
    private val restaurantName = "학생회관 식당"
    private val menuName = "제육덮밥"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_review, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewReviews)
        btnWriteReview = view.findViewById(R.id.btnWriteReview)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ReviewAdapter(emptyList())
        recyclerView.adapter = adapter

        // 버튼 클릭 시 WriteReviewFragment로 이동
        btnWriteReview.setOnClickListener {
            val writeFragment = WriteReviewFragment.newInstance(restaurantName, menuName)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, writeFragment)  // ID 이름을 fragmentContainer로 수정
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        loadReviews()
    }

    private fun loadReviews() {

        val allReviews = ReviewStorage.getAllReviews()
        val filteredReviews = allReviews.filter {
            it.restaurantName == restaurantName && it.menuName == menuName
        }
        adapter.updateList(filteredReviews)
    }
}