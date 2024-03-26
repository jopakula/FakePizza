package com.example.fakepizza.ui.screens.tab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object MenuTab : Tab {
    @Composable
    override fun Content() {
        Box(
            modifier =
                Modifier
                    .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "MenuTab")
        }
    }

    override val options: TabOptions
        @Composable
        get() =
            remember {
                TabOptions(
                    index = 1u,
                    title = "Menu",
                    icon = null,
                )
            }
}
