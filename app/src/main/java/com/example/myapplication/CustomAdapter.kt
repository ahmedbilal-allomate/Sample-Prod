package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (var userList : ArrayList<User>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() ,Filterable{

    private var filterItem : FilterItem? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
       holder.tvTextView.text = userList[position].name
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tvTextView = itemView.findViewById<TextView>(R.id.tvItem)

    }

    override fun getFilter(): Filter {
        if (filterItem == null){
            filterItem = FilterItem(userList,this)
        }
        return filterItem as FilterItem
    }

}