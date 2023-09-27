package com.example.bestbuyselltime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bestbuyselltime.databinding.FragmentMarketBinding

class MarketFragment: Fragment(R.layout.fragment_market) {
    private val binding by viewBinding(FragmentMarketBinding::bind)
    private val adapter = MarketAdapter()
    val viewModel = MarketViewModel(LoadCandlesUseCase(), OperationUseCase)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCandles.adapter = adapter
        binding.rvCandles.layoutManager = LinearLayoutManager(requireContext())
        viewModel.loadCandles()
        viewModel.candles.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        binding.cvBuy.setOnClickListener{
            viewModel.buy(price = binding.tvBuyPrice.text.toString().toDouble(),
                count = binding.etBuyCount.text.toString())
        }
        viewModel.currentPrice.observe(viewLifecycleOwner){
            binding.tvBuyPrice.text = it.toString()
        }
    }
}