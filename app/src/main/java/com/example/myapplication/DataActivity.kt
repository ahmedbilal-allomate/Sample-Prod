package com.example.myapplication

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DataActivity : AppCompatActivity() {

    private val users = ArrayList<User>()
    private lateinit var svSearch : SearchView
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_activtity)
        recyclerView = findViewById(R.id.rvUser)
        svSearch =findViewById(R.id.svSearch)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDummyData()
    }

    private fun addDummyData(){
        users.add(User("Bilal","Expo","12345","200"))
        users.add(User("Usama","Johar","3456789","500"))
        users.add(User("Osama","Town","213424","700"))
        users.add(User("Wakas","Town","213424","700"))
        users.add(User("Adeel","Town","213424","700"))
        adapter = CustomAdapter(users)
        recyclerView.adapter = adapter


        svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }



}
