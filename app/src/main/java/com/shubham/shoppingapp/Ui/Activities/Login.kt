package com.shubham.shoppingapp.Ui.Activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shubham.shoppingapp.R
import com.shubham.shoppingapp.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.main)

        init()
    }

    fun init(){
        binding.phone.setOnClickListener {
            startActivity(Intent(this@Login, Register::class.java))
        }

        binding.newacc.setOnClickListener { startActivity(Intent(this@Login, NewAccount::class.java)) }
    }


}