package com.example.myapplication

import android.widget.Filter

class FilterItem(filterList: ArrayList<User>, private val adapter: CustomAdapter) : Filter() {

    private val filterList: ArrayList<User> = filterList

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        var constraint1: CharSequence? = constraint
        val result = FilterResults()

        if (constraint1 != null && constraint1.isNotEmpty()) {
            constraint1 = constraint1.toString().uppercase()

            var filteredModel =
                filterList.filter { it.name.uppercase().contains(constraint1) } as ArrayList<User>
            result.values = filteredModel
        } else {
            result.values = filterList
        }

        return result
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        if (results != null) {
            adapter.userList = results.values as ArrayList<User>
            adapter.notifyDataSetChanged()
        }
    }
}