package com.example.myapplication.repositories

import com.example.myapplication.data.ApiCall
import com.example.myapplication.data.SafeApiRequest

class DataRepository(private val api :ApiCall) : SafeApiRequest(){
    suspend fun getData() = apiRequest { api.getData() }
}