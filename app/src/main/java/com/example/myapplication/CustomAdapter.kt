package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemListBinding
import com.example.myapplication.model.DummyDataItem
import com.example.myapplication.model.User

class CustomAdapter (var userList : ArrayList<DummyDataItem>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() ,Filterable{

    private var filterItem : FilterItem? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),R.layout.item_list,parent,false))

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
       holder.binding.listItem = userList[position]
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getFilter(): Filter {
        if (filterItem == null){
            filterItem = FilterItem(userList,this)
        }
        return filterItem as FilterItem
    }

}