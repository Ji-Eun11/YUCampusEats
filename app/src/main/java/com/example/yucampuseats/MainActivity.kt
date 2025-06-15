package com.example.yucampuseats

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.yucampuseats.ui.HumanitiesStaffFragment
import com.example.yucampuseats.ui.ReviewFragment
import com.example.yucampuseats.ui.StudentHallFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnStudentHall: Button
    private lateinit var btnHumanitiesStaff: Button
    private lateinit var btnNaturalStudent: Button
    private lateinit var btnReview: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStudentHall = findViewById(R.id.btnStudentHall)
        btnHumanitiesStaff = findViewById(R.id.btnHumanitiesStaff)
        btnNaturalStudent = findViewById(R.id.btnNaturalStudent)
        btnReview = findViewById(R.id.btnReview)

        // 처음 앱 실행 시 학생회관 식당 프래그먼트 보여주기
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, StudentHallFragment())
            .commit()

        btnStudentHall.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, StudentHallFragment())
                .commit()
        }

        btnHumanitiesStaff.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HumanitiesStaffFragment())
                .commit()
        }

        // 리뷰 보기 버튼 클릭 시 ReviewFragment 로 전환
        btnReview.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ReviewFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
