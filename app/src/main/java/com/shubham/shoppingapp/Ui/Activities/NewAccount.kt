package com.shubham.shoppingapp.Ui.Activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shubham.shoppingapp.R
import com.shubham.shoppingapp.Utils.utilFunctions.Companion.hideProgres
import com.shubham.shoppingapp.Utils.utilFunctions.Companion.showProgress
import com.shubham.shoppingapp.databinding.ActivityNewAccountBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NewAccount : AppCompatActivity() {

    lateinit var binding: ActivityNewAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNewAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
    }

    private fun init(){

        binding.createAcc.setOnClickListener {
            createAccount()
        }

    }

    fun createAccount(){
       GlobalScope.launch {
           showProgress(binding.pb)
           delay(2000)
           hideProgres(binding.pb)

           startActivity(Intent(this@NewAccount, Dashboard::class.java))


       }
    }


}