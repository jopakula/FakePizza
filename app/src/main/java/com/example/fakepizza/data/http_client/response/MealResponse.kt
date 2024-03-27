package com.example.fakepizza.data.http_client.response

import com.example.fakepizza.data.http_client.models.Meal

data class MealResponse(
    val meals: List<Meal>,
)
