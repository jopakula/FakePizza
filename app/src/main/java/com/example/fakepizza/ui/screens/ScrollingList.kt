package com.example.fakepizza.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fakepizza.data.http_client.HttpClient
import com.example.fakepizza.data.http_client.models.Meal

@Suppress("ktlint:standard:function-naming")
@Composable
fun ScrollingList(selectedCategory: String) {
    val scrollState = rememberLazyListState()
    var meals by remember { mutableStateOf(listOf<Meal>()) }

    LaunchedEffect(Unit) {
        try {
            val response = HttpClient.api.searchMeals()
            meals = response.meals
        } catch (e: Exception) {
            Log.e("TabsList", "Error$e")
        }
    }

    LazyColumn(
        modifier =
            Modifier
                .padding(top = 60.dp)
                .background(Color.White),
        state = scrollState,
    ) {
        val filteredMeals = meals.filter { it.strCategory == selectedCategory }
        items(filteredMeals) { meal ->
            MealCard(meal = meal)
        }
    }
}
