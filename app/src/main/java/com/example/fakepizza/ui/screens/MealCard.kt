package com.example.fakepizza.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fakepizza.data.http_client.models.Meal

@Suppress("ktlint:standard:function-naming")
@Composable
fun MealCard(meal: Meal) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        elevation = 8.dp,
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(text = meal.strMeal, style = MaterialTheme.typography.h6)
            Text(text = meal.strCategory, style = MaterialTheme.typography.subtitle1)
            Text(text = meal.strArea, style = MaterialTheme.typography.subtitle2)
        }
    }
}
