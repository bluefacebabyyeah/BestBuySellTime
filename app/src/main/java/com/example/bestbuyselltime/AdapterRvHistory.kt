package com.example.bestbuyselltime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat

class AdapterRvHistory() : ListAdapter<Operation, AdapterRvHistory.MyViewHolder>(
    object: DiffUtil.ItemCallback<Operation>() {
        override fun areItemsTheSame(oldItem: Operation, newItem: Operation): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Operation, newItem: Operation): Boolean {
            return oldItem == newItem
        }

    }
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.tvDate.text = "Hello ${System.currentTimeMillis()}"

    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
    }
}