package com.example.fakepizza.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.fakepizza.ui.screens.tab.BasketTab
import com.example.fakepizza.ui.screens.tab.MenuTab
import com.example.fakepizza.ui.screens.tab.ProfileTab

@Suppress("ktlint:standard:function-naming")
@Composable
fun MainScreen() {
    TabNavigator(tab = MenuTab) {
        Scaffold(
            bottomBar = {
                BottomNavigation {
                    TabNavigatorItem(MenuTab)
                    TabNavigatorItem(ProfileTab)
                    TabNavigatorItem(BasketTab)
                }
            },
            content = { paddingValues ->
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    contentAlignment = Alignment.Center,
                ) {
                    CurrentTab()
                }
            },
        )
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
private fun RowScope.TabNavigatorItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            Text(
                tab.options.title,
            )
        },
    )
}
