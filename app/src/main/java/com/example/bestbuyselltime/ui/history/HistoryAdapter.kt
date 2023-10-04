package com.example.bestbuyselltime.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bestbuyselltime.R
import com.example.bestbuyselltime.databinding.TransactionViewBinding

class HistoryAdapter() : ListAdapter<HistoryOperationItem, HistoryAdapter.MyViewHolder>(
    object: DiffUtil.ItemCallback<HistoryOperationItem>() {
        override fun areItemsTheSame(oldItem: HistoryOperationItem, newItem: HistoryOperationItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: HistoryOperationItem, newItem: HistoryOperationItem): Boolean {
            return oldItem == newItem
        }

    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.transaction_view, parent, false)
        return MyViewHolder(itemView, TransactionViewBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    class MyViewHolder(itemView: View, val binding: TransactionViewBinding) : RecyclerView.ViewHolder(itemView) {
        fun bind(historyOperationItem: HistoryOperationItem){
            binding.tvDate.text = historyOperationItem.operation.date.toString()
            binding.tvPrice.text = historyOperationItem.operation.price.toString()
            binding.tvAmplifier.text = historyOperationItem.operation.ratio.toString()
            binding.tvTransactionType.text = historyOperationItem.operation.type.toString()
            binding.tvCurrency.text = historyOperationItem.operation.currency.toString()
            binding.tvSummary.text = historyOperationItem.operation.sum.toString()
            binding.root.setOnClickListener{historyOperationItem
                .onClick(historyOperationItem.operation)}
        }
    }
}