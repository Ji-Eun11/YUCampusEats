package com.example.yucampuseats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yucampuseats.R
import com.example.yucampuseats.model.ReviewStorage

class ReviewFragment : Fragment(R.layout.fragment_review) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReviewAdapter
    private lateinit var btnWriteReview: Button

    private var restaurantName: String = ""
    private var menuName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            restaurantName = it.getString("restaurantName") ?: ""
            menuName = it.getString("menuName") ?: ""
        }
    }

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

        btnWriteReview.setOnClickListener {
            val writeReviewFragment = WriteReviewFragment.newInstance(restaurantName, menuName)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, writeReviewFragment)
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

    companion object {
        fun newInstance(restaurantName: String, menuName: String): ReviewFragment {
            val fragment = ReviewFragment()
            val args = Bundle()
            args.putString("restaurantName", restaurantName)
            args.putString("menuName", menuName)
            fragment.arguments = args
            return fragment
        }
    }
}