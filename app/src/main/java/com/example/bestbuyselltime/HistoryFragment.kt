package com.example.bestbuyselltime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bestbuyselltime.databinding.FragmentHistoryBinding
import com.example.bestbuyselltime.databinding.FragmentMainBinding

class HistoryFragment : Fragment(R.layout.fragment_history) {
    private val binding by viewBinding(FragmentHistoryBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonToTools.setOnClickListener {
            findNavController().navigate(R.id.action_historyFragment2_to_closePositionFragment)
        }
    }
}