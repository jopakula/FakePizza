package com.example.fakepizza.data.http_client

import com.example.fakepizza.data.http_client.response.CategoryResponse
import com.example.fakepizza.data.http_client.response.MealResponse
import retrofit2.http.GET

interface Api {
    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse

    @GET("search.php?s")
    suspend fun searchMeals(): MealResponse
}
