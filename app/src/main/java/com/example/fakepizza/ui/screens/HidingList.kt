package com.example.fakepizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fakepizza.R

@Suppress("ktlint:standard:function-naming")
@Composable
fun HidingList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(5) {
            Box(
                modifier =
                    Modifier
                        .background(Color.White)
                        .height(150.dp)
                        .clip(RoundedCornerShape(10.dp)),
            ) {
                Image(painter = painterResource(id = R.drawable.bunner_1), contentDescription = "pizza 1")
            }
        }
    }
}
