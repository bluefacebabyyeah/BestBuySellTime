package com.example.bestbuyselltime.ui.closeposition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bestbuyselltime.R
import com.example.bestbuyselltime.data.repo.OperationRepository
import com.example.bestbuyselltime.databinding.FragmentClosepositionBinding
import com.example.bestbuyselltime.domain.usecases.OperationUseCase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClosePositionFragment : Fragment(R.layout.fragment_closeposition) {
    private val binding by viewBinding(FragmentClosepositionBinding::bind)
    private val args by navArgs<ClosePositionFragmentArgs>()
    private val viewModel by viewModels<ClosePositionViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        viewModel.loadOperation(args.operation)
        binding.bClosePosition.setOnClickListener {
            viewModel.closeOperation()
            findNavController().popBackStack()
        }
    }
}