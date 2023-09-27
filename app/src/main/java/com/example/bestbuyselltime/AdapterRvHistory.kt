package com.example.bestbuyselltime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bestbuyselltime.databinding.ItemCandleBinding
import com.example.bestbuyselltime.databinding.TransactionViewBinding
import java.text.DateFormat

class AdapterRvHistory() : ListAdapter<OperationHistoryItem, AdapterRvHistory.MyViewHolder>(
    object: DiffUtil.ItemCallback<OperationHistoryItem>() {
        override fun areItemsTheSame(oldItem: OperationHistoryItem, newItem: OperationHistoryItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: OperationHistoryItem, newItem: OperationHistoryItem): Boolean {
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
        fun bind(operationHistoryItem: OperationHistoryItem){
            binding.tvDate.text = operationHistoryItem.operation.date.toString()
            binding.tvPrice.text = operationHistoryItem.operation.price.toString()
            binding.tvAmplifier.text = operationHistoryItem.operation.ratio.toString()
            binding.tvTransactionType.text = operationHistoryItem.operation.type.toString()
            binding.tvCurrency.text = operationHistoryItem.operation.currency.toString()
            binding.tvSummary.text = operationHistoryItem.operation.sum.toString()
            binding.root.setOnClickListener{operationHistoryItem
                .onClick(operationHistoryItem.operation)}
        }
    }
}