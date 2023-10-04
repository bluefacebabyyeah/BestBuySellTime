package com.example.bestbuyselltime.ui.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bestbuyselltime.R
import com.example.bestbuyselltime.data.repo.OperationRepository
import com.example.bestbuyselltime.databinding.FragmentMarketBinding
import com.example.bestbuyselltime.domain.usecases.LoadCandlesUseCase
import com.example.bestbuyselltime.domain.usecases.OperationUseCase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketFragment: Fragment(R.layout.fragment_market) {
    private val binding by viewBinding(FragmentMarketBinding::bind)
    private val adapter = MarketAdapter()
    private val viewModel by viewModels<MarketViewModel>()
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