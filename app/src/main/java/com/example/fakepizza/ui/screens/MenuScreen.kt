package com.example.fakepizza.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Suppress("ktlint:standard:function-naming")
class MenuScreen : Screen {
    @Composable
    override fun Content() {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.LightGray),
        ) {
            val state = rememberCollapsingToolbarScaffoldState()
            var selectedCategory by remember { mutableStateOf("") }

            CollapsingToolbarScaffold(
                modifier =
                    Modifier
                        .fillMaxWidth(),
                state = state,
                scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
                toolbar = {
                    Box(
                        modifier =
                            Modifier
                                .background(Color.White)
                                .fillMaxWidth()
                                .height(56.dp)
                                .pin(),
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                    ) {
                        TitleList()
                        HidingList()
                    }
                },
            ) {
                TabsList(onCategorySelected = { category ->
                    selectedCategory = category
                })
                ScrollingList(selectedCategory)
            }
        }
    }
}
