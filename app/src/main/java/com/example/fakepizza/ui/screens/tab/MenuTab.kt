package com.example.fakepizza.ui.screens.tab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object MenuTab : Tab {
    @Composable
    override fun Content() {
        MenuScreen().Content()
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
