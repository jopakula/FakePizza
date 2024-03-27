package com.example.fakepizza.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fakepizza.data.http_client.HttpClient
import com.example.fakepizza.ui.theme.SelectedBackgroundColor
import com.example.fakepizza.ui.theme.SelectedColor
import com.example.fakepizza.ui.theme.UnselectedColor

@Suppress("ktlint:standard:function-naming")
@Composable
fun TabsList(onCategorySelected: (String) -> Unit) {
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
            modifier =
                Modifier
                    .fillMaxWidth(),
            selectedTabIndex = selectedTabIndex,
            edgePadding = 8.dp,
            indicator = { },
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    modifier =
                        Modifier
                            .padding(8.dp)
                            .shadow(elevation = 6.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (selectedTabIndex == index) SelectedBackgroundColor else Color.White),
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        onCategorySelected(tab)
                    },
                    selectedContentColor = SelectedColor,
                    unselectedContentColor = UnselectedColor,
                    text = { Text(text = tab) },
                )
            }
        }
    }
}
