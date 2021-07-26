package com.example.myapplication.ui

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CustomAdapter
import com.example.myapplication.R
import com.example.myapplication.data.ApiCall
import com.example.myapplication.databinding.ActivityDataActivtityBinding
import com.example.myapplication.model.User
import com.example.myapplication.repositories.DataRepository
import com.example.myapplication.viewModels.DataViewModel
import com.example.myapplication.viewModels.DataViewModelFactory

class DataActivity : AppCompatActivity() {
    private lateinit var factory: DataViewModelFactory
    private lateinit var adapter: CustomAdapter
    private lateinit var viewModel: DataViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDataActivtityBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_activtity)
        val repository = DataRepository(ApiCall())
        factory = DataViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(DataViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.getData()
        viewModel.data.observe(this, { user ->
            binding.rvUser.also {
                adapter = CustomAdapter(user)
                it.layoutManager = LinearLayoutManager(this)
                it.adapter = adapter
            }
        })

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
