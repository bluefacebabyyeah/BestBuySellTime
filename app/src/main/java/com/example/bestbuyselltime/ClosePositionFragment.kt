package com.example.bestbuyselltime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bestbuyselltime.databinding.FragmentClosepositionBinding
import com.example.bestbuyselltime.databinding.FragmentHistoryBinding

class ClosePositionFragment : Fragment(R.layout.fragment_closeposition) {
    private val binding by viewBinding(FragmentClosepositionBinding::bind)
    val viewModel = ClosePositionViewModel(OperationUseCase)
    private val args by navArgs<ClosePositionFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadOperation(args.operation)
        binding.bClosePosition.setOnClickListener {
            viewModel.closeOperation()
            findNavController().popBackStack()
        }
    }
}