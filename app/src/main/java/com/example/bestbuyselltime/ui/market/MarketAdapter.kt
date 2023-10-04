package com.example.bestbuyselltime.ui.market

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bestbuyselltime.R
import com.example.bestbuyselltime.databinding.ItemCandleBinding
import com.example.bestbuyselltime.domain.models.Candle
import com.example.bestbuyselltime.util.formatAsDate


class MarketAdapter() : ListAdapter<Candle, MarketAdapter.MyViewHolder>(
    object: DiffUtil.ItemCallback<Candle>() {
        override fun areItemsTheSame(oldItem: Candle, newItem: Candle): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Candle, newItem: Candle): Boolean {
            return oldItem == newItem
        }

    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_candle, parent, false)
        return MyViewHolder(itemView, ItemCandleBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    class MyViewHolder(itemView: View, val binding: ItemCandleBinding) : RecyclerView.ViewHolder(itemView) {
        fun bind(candle: Candle){
            binding.tvDate.text = candle.date.formatAsDate("dd.MM.yyyy")
            binding.tvCurrentPrice.text = candle.newPrice.toString()
            binding.tvOldPrice.text = candle.oldPrice.toString()
            binding.tvDiffPrice.text = candle.diffPrice.toString()
            binding.tvDiffPricePercent.text = candle.diffPricePercent.toString()
        }
    }
}