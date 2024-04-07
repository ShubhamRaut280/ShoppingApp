package com.shubham.shoppingapp.Retrofit

import com.shubham.shoppingapp.Utils.Constants.Companion.PRODUCT_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(PRODUCT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
