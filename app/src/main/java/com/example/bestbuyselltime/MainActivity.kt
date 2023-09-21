package com.example.bestbuyselltime

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bestbuyselltime.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity: AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var bottomNav : BottomNavigationView
    // val adapter = AdapterRvHistory()
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.market -> {
                    loadFragment(MarketFragment())
                    true
                }

                R.id.market -> {
                    loadFragment(MarketFragment())
                    true
                }

                R.id.market -> {
                    loadFragment(MarketFragment())
                    true
                }

                else -> {
                    false
                }
            }
            /*
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         */
            /* val recyclerView: RecyclerView = findViewById(R.id.rv_history)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        recyclerView.adapter = adapter
        adapter.submitList(listOf(Operation(),Operation(), Operation()))
        */
            /* binding.bTools.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id., MarketFragment())
                .commit()
        }
         */
        }
    }
}