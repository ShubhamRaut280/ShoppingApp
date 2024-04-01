package com.shubham.shoppingapp.Ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shubham.shoppingapp.R
import com.shubham.shoppingapp.Utils.utilFunctions.Companion.showSnackbar
import com.shubham.shoppingapp.databinding.ActivityRegisterBinding
import com.shubham.shoppingapp.databinding.FragmentPhoneNumberBinding


class PhoneNumberFragment : Fragment() {

    lateinit var binding: FragmentPhoneNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneNumberBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init(){
        binding.getOtp.setOnClickListener { sendOtp(binding.phone.text.toString())}
    }

    fun sendOtp (number:String){
        if(number.length != 10)
            showSnackbar(requireView(), "Please enter a valid number.")
        else{
            showSnackbar(requireView(), "Otp sent successsfully")
            findNavController().navigate(R.id.action_phoneNumberFragment_to_otpFragment)
        }
    }



}