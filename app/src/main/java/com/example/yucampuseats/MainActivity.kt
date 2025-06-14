package com.example.yucampuseats

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.yucampuseats.ui.StudentHallFragment
import com.example.yucampuseats.ui.HumanitiesStaffFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 기본 학생회관 메뉴 보여주기
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, StudentHallFragment())
            .commit()

        // 식당별로 버튼 클릭 시 fragment 교체 (예시)
        findViewById<Button>(R.id.btnStudentHall).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, StudentHallFragment())
                .commit()
        }

        findViewById<Button>(R.id.btnHumanitiesStaff).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HumanitiesStaffFragment())
                .commit()
        }

    }
}