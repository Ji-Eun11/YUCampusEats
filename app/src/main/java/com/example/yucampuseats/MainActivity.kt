package com.example.yucampuseats

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.yucampuseats.ui.MenuFragment
import com.example.yucampuseats.ui.PriceFragment
import com.example.yucampuseats.ui.ReviewFragment
import com.example.yucampuseats.ui.ImageFragment
import com.example.yucampuseats.ui.bottomnavigation.BottomNavigationView

class MainActivity : AppComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MenuFragment())
            .commit()

        bottomNav.setOnItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.nav_menu -> MenuFragment()
                R.id.nav_price -> PriceFragment()
                R.id.nav_review -> ReviewFragment()
                R.id.nav_image -> ImageFragment()
                else -> MenuFragment()
            }
            supportFragmentManger.beginTranscation()
                .replace(R.id.fragment_container, selectedFragment)
                .commit()

            true
        }
    }
}
