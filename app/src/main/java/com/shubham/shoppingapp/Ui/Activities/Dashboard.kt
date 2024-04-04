package com.shubham.shoppingapp.Ui.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.shubham.shoppingapp.R
import com.shubham.shoppingapp.Ui.Fragments.DashboardFragments.Cart
import com.shubham.shoppingapp.Ui.Fragments.DashboardFragments.Home
import com.shubham.shoppingapp.Ui.Fragments.DashboardFragments.Profile
import com.shubham.shoppingapp.Ui.Fragments.DashboardFragments.Search
import com.shubham.shoppingapp.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {


    lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    private fun init(){
        replaceFragment(Home())

        // Set click listeners for menu items
        binding.bottomNavForDashboard.setOnItemSelectedListener {menuItem->
            when (menuItem.itemId) {
                R.id.homemenu -> replaceFragment(Home())
                R.id.searchmenu -> replaceFragment(Search())
                R.id.cartmenu -> replaceFragment(Cart())
                R.id.accountmenu -> replaceFragment(Profile())
            }
            true
        }

    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }


}