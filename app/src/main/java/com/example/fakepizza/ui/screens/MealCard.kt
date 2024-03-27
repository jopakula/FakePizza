package com.example.fakepizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakepizza.R
import com.example.fakepizza.data.http_client.models.Meal
import com.example.fakepizza.ui.theme.SelectedColor

@Suppress("ktlint:standard:function-naming")
@Composable
fun MealCard(meal: Meal) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(150.dp),
        elevation = 2.dp,
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
        ) {
            val image = painterResource(id = R.drawable.pizza)
            Image(
                modifier =
                    Modifier
                        .size(135.dp),
                painter = image,
                contentDescription = "Meal Image",
            )

            Column(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = meal.strMeal,
                    style = TextStyle(fontSize = 20.sp, color = Color.Black),
                )
                Spacer(modifier = Modifier.size(4.dp))
                val ingredients =
                    listOf(
                        meal.strIngredient1,
                        meal.strIngredient2,
                        meal.strIngredient3,
                        meal.strIngredient4,
                        meal.strIngredient5,
                        meal.strIngredient6,
                        meal.strIngredient7,
                        meal.strIngredient8,
                        meal.strIngredient9,
                        meal.strIngredient10,
                    ).joinToString(", ")
                Text(
                    text = ingredients,
                    style = TextStyle(fontSize = 12.sp, color = Color.Gray),
                )
                Spacer(
                    modifier =
                        Modifier
                            .size(2.dp),
                )
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    Box(
                        modifier =
                            Modifier
                                .border(
                                    width = 1.dp,
                                    color = SelectedColor,
                                    shape = RoundedCornerShape(4.dp),
                                )
                                .padding(12.dp),
                    ) {
                        Text(
                            text = "от 345 р",
                            color = SelectedColor,
                        )
                    }
                }
            }
        }
    }
}
