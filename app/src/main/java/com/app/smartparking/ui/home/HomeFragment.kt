@file:Suppress("RedundantNullableReturnType", "RedundantNullableReturnType")

package com.app.smartparking.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.app.smartparking.databinding.FragmentHomeBinding

@Suppress("RedundantNullableReturnType", "RedundantNullableReturnType")
class HomeFragment : Fragment() {
    private lateinit var parkViewModel: ParkViewModel
    private lateinit var binding : FragmentHomeBinding
    private val updateInterval: Long = 5000 // 5 seconds
    private val handler = Handler()
    private val updateRunnable = object : Runnable {
        override fun run() {
            parkViewModel.showData()
            handler.postDelayed(this, updateInterval)
        }
    }
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

        parkViewModel = ViewModelProvider(this).get(ParkViewModel::class.java)

        val adapter = ParkAdapter(emptyList(), this)
        binding.rvDevice.layoutManager = GridLayoutManager(context, 5)
        binding.rvDevice.adapter = adapter

        parkViewModel.getData().observe(viewLifecycleOwner, Observer { data ->
            if (data != null) {
                adapter.updateData(data)
                binding.rvDevice.visibility = View.VISIBLE
            } else {
                binding.rvDevice.visibility = View.GONE
                Toast.makeText(context, "Failed to Load Data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(updateRunnable, updateInterval)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(updateRunnable)
    }
}