package com.example.rickmortyproject.model.retrofit

object Common {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}