package com.example.myapplication.data

import com.example.myapplication.model.DummyData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiCall {

    @GET("posts")
    suspend fun getData() : Response<DummyData>


    companion object{
        operator fun invoke() : ApiCall{
           return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()
                .create(ApiCall::class.java)
        }
    }
}