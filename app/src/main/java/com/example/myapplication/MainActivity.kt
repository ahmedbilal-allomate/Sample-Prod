package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    private val mapValues = mapOf("key1" to 13,"key2" to 15,"key3" to 19)
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
           // tvDetails.text = shortItems()
           // tvDetails.text = pairingItems()
            tvDetails.text = plusOperator().toString()
            Toast.makeText(this,gettingLength(null).toString(),Toast.LENGTH_LONG).show()
        }

    }


    private fun filterItems(): String {
        return fruits.filter { it.startsWith("a") }.toString()
    }

    private fun shortItems(): String {
        return fruits.sortedBy { it.length }.toString()
    }

    private fun mapItems(): String {
        return fruits.map { it.uppercase() }.toString()
    }



    private fun pairingItems() : String{
        return mapValues.filter {(key,value) -> key.endsWith("2") && value >4}.toString()
    }

    private fun gettingLength(obj : Any?) :Any?{
        if ( obj is String)
        {
            return obj.length
        }
        if (obj is Int){
            return obj.dec()
        }

        return null
    }


    private fun plusOperator(): Any {
        val numberList1 = listOf("One", 2, "3")
        val numberList2 = listOf(2, "3", 6)
        return numberList1 + numberList2
    }



}