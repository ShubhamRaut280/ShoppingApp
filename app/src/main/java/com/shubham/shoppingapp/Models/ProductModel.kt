package com.shubham.shoppingapp.Models

data class ProductModel(
    val availability: Boolean,
    val brand: String,
    val category: String,
    val description: String,
    val discount: Int,
    val image: String,
    val name: String,
    val price: Double,
    val product_id: Int,
    val rating: Double,
    val reviews: List<Review>,
    val unit: String
)