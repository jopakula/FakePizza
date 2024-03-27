package com.example.fakepizza.ui.screens.tab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.fakepizza.R
import com.example.fakepizza.ui.screens.MenuScreen

object MenuTab : Tab {
    @Composable
    override fun Content() {
        MenuScreen().Content()
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(id = R.string.food_title)
            val icon = painterResource(id = R.drawable.icon_food)
            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon,
                )
            }
        }
}
