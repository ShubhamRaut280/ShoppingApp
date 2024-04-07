package com.shubham.shoppingapp.Interfaces

interface GenCallback<T> {
    fun onSuccess(data: T)
    fun onFailure(message: String)
}
