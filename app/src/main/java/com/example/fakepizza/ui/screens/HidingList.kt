package com.example.fakepizza.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
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
                        .background(Color.Yellow)
                        .height(120.dp),
            ) {
                Image(painter = painterResource(id = R.drawable.bunner_1), contentDescription = "pizza 1")
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun SubList1(offsetState: MutableState<Float>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(5) {
            Box(
                modifier =
                    Modifier
                        .background(Color.Yellow)
                        .height(120.dp)
                        .offset { IntOffset(x = 0, y = -offsetState.value.dp.coerceIn(0.dp, 200.dp).value.toInt()) },
            ) {
                Image(painter = painterResource(id = R.drawable.bunner_1), contentDescription = "pizza 1")
            }
        }
    }
}
