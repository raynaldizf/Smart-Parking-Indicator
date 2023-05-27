@file:Suppress("RedundantNullableReturnType", "RedundantNullableReturnType")

package com.app.smartparking.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.app.smartparking.databinding.FragmentHomeBinding

@Suppress("RedundantNullableReturnType", "RedundantNullableReturnType")
class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[ParkViewModel::class.java]
        viewModel.getData().observe(viewLifecycleOwner) {
            if (it != null) {
                binding.rvDevice.layoutManager = GridLayoutManager(context, 5)
                val adapter = ParkAdapter(it, this)
                binding.rvDevice.adapter = adapter
            }else{
                binding.rvDevice.visibility = View.GONE
                Toast.makeText(context,"Failed to Load Data",Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.showData()
    }
}