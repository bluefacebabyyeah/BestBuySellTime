package com.example.bestbuyselltime.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bestbuyselltime.domain.usecases.OperationUseCase
import com.example.bestbuyselltime.R
import com.example.bestbuyselltime.data.repo.OperationRepository
import com.example.bestbuyselltime.databinding.FragmentHistoryBinding
import com.example.bestbuyselltime.ui.closeposition.ClosePositionFragmentArgs
import com.example.bestbuyselltime.ui.closeposition.ClosePositionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {
    private val binding by viewBinding(FragmentHistoryBinding::bind)
    private val adapter = HistoryAdapter()
    private val viewModel by viewModels<HistoryViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHistory.adapter = adapter
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
        viewModel.operations.observe(viewLifecycleOwner){
            adapter.submitList(it.toList())
        }
        viewModel.lastClickedItem.observe(viewLifecycleOwner){
            findNavController().navigate(
                R.id.action_historyFragment2_to_closePositionFragment,
                ClosePositionFragmentArgs(it?:return@observe).toBundle()
            )
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadOperations()
    }
}