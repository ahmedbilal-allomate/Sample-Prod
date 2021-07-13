package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    private lateinit var btnFilter: Button
    private lateinit var btnMap: Button
    private lateinit var btnShort: Button
    private lateinit var tvDetails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFilter = findViewById(R.id.btnFilter)
        btnMap = findViewById(R.id.btnMap)
        btnShort = findViewById(R.id.btnShort)
        tvDetails = findViewById(R.id.tvDetails)

        listeners()
    }

    private fun listeners() {
        btnFilter.setOnClickListener() {
            tvDetails.text = filterItems()
        }
        btnMap.setOnClickListener() {
            tvDetails.text = mapItems()
        }
        btnShort.setOnClickListener() {
            tvDetails.text = shortItems()
        }

    }


    private fun filterItems(): String {
        return fruits.filter { it.startsWith("a") }.toString()
    }

    private fun shortItems(): String {
        return fruits.sortedBy { it.uppercase() }.toString()
    }

    private fun mapItems(): String {
        return fruits.map { it.uppercase() }.toString()
    }
}