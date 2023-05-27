@file:Suppress("unused", "unused", "unused", "unused", "unused")

package com.app.smartparking.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.app.smartparking.R
import com.app.smartparking.data.model.request.Parkiran
import com.app.smartparking.databinding.ListDeviceBinding
import org.json.JSONArray

@Suppress("unused", "unused", "unused", "unused", "unused")
class ParkAdapter(private var data : List<Parkiran>,private val fragment: Fragment) : RecyclerView.Adapter<ParkAdapter.ViewHolder>() {
    class ViewHolder (val binding : ListDeviceBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListDeviceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val deviceNumber = "Device ${position + 1}"

        val status = data[position].status.toString()
        if (status == "1") {
            holder.binding.image.setImageResource(com.app.smartparking.R.drawable.red)
        }else{
            holder.binding.image.setImageResource(com.app.smartparking.R.drawable.green)
        }

        holder.binding.tvDeviceName.text = deviceNumber

    }

    fun updateData(newData: List<Parkiran>) {
        data = newData
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(data: Parkiran)
    }
}