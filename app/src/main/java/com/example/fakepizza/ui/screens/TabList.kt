package com.example.fakepizza.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
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

@Suppress("ktlint:standard:function-naming")
@Composable
fun TabsList() {
    var tabs by remember { mutableStateOf(listOf<String>()) }
    var selectedTabIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        try {
            val response = HttpClient.api.getCategories()
            tabs = response.categories.map { it.strCategory }
        } catch (e: Exception) {
            Log.e("TabsList", "Error$e")
        }
    }

    if (tabs.isNotEmpty()) {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth(),
            edgePadding = 14.dp,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = Color.Gray,
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                )
            },
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.LightGray,
                    text = { Text(text = tab) },
                )
            }
        }
    }
}
