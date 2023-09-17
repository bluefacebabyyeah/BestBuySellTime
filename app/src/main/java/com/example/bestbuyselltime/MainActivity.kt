package com.example.bestbuyselltime

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bestbuyselltime.databinding.ActivityMainBinding


class MainActivity: AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    // val adapter = AdapterRvHistory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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