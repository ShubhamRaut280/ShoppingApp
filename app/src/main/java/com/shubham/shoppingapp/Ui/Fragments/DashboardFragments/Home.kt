package com.shubham.shoppingapp.Ui.Fragments.DashboardFragments

import com.shubham.shoppingapp.Adapters.ProductAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shubham.shoppingapp.Interfaces.GenCallback
import com.shubham.shoppingapp.Models.ProductModel
import com.shubham.shoppingapp.Utils.utilFunctions.Companion.showSnackbar
import com.shubham.shoppingapp.databinding.FragmentHomeBinding

class Home : Fragment() {

    lateinit var binding:FragmentHomeBinding
    lateinit var adapter: ProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        setUpRecycler(binding.productRecycler1)

        fetchProducts()


    }

    private fun fetchProducts(){
        ApiRepository.getProducts(object : GenCallback<List<ProductModel>> {
            override fun onSuccess(data: List<ProductModel>) {
                adapter = ProductAdapter(requireContext(), data)
                binding.productRecycler1.adapter = adapter
            }

            override fun onFailure(message: String) {
                showSnackbar(requireView(), message)
            }
        })
    }
    private fun setUpRecycler(recyclerView: RecyclerView){
        val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
    }

}