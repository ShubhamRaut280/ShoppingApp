package com.shubham.shoppingapp.Ui.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.shubham.shoppingapp.R
import com.shubham.shoppingapp.Ui.Fragments.OtpFragment
import com.shubham.shoppingapp.Ui.Fragments.PhoneNumberFragment
import com.shubham.shoppingapp.databinding.ActivityRegisterBinding


class Register : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this,R.color.main)

        init()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

    fun init(){
        loadFragment(PhoneNumberFragment())
//        binding.backBtn.setOnClickListener {
//            onBackPressedDispatcher.onBackPressed()
//        }
        binding.backBtn.setOnClickListener {
            loadFragment(OtpFragment())
        }
    }


     fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
            return true
        }
        return false
    }

}