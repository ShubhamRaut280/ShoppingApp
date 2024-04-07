package com.shubham.shoppingapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.textview.MaterialTextView
import com.shubham.shoppingapp.Models.ProductModel
import com.shubham.shoppingapp.R

class ProductAdapter(private val context: Context, private val productList: List<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_layout_homepage, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        Glide.with(context).load(product.image).into(holder.productImg)
        holder.productName.text = product.name
        holder.productPrice.text = "$" + product.price
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImg: ImageView = itemView.findViewById(R.id.productImg)
        val productName: MaterialTextView = itemView.findViewById(R.id.productName)
        val productPrice: MaterialTextView = itemView.findViewById(R.id.productPrice)
    }
}
