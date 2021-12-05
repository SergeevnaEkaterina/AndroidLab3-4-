package com.spbstu.lab3_5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import spbstu.lab3_5.R
import spbstu.lab3_5.databinding.Fragment1Binding

class Fragment1: Fragment() {

    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bnToSecond.setOnClickListener {
            findNavController().navigate(R.id.from_first_to_second)
        }
    }
}