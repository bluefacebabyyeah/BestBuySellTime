package com.example.bestbuyselltime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bestbuyselltime.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bMain.setOnClickListener {
            childFragmentManager
                .beginTransaction().replace(R.id.fcvMain, MarketFragment())
                .commit()
        }
    }
}