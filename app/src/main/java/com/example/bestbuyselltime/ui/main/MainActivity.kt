package com.example.bestbuyselltime.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.bestbuyselltime.R
import com.example.bestbuyselltime.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    // val adapter = AdapterRvHistory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = (supportFragmentManager
            .findFragmentById(R.id.fcvMain) as NavHostFragment).navController
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
        binding.bottomNav.setOnItemReselectedListener {
            navController.popBackStack()
            }
        }
    }