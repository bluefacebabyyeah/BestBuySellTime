package com.example.bestbuyselltime.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bestbuyselltime.R
import com.example.bestbuyselltime.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}