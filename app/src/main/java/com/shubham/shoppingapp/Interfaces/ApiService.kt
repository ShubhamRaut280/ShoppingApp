package com.shubham.shoppingapp.Interfaces

import com.shubham.shoppingapp.Models.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/products")
    fun getApiProducts(): Call<List<ProductModel>>
}