package com.example.fakepizza.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.fakepizza.ui.screens.tab.BasketTab
import com.example.fakepizza.ui.screens.tab.MenuTab
import com.example.fakepizza.ui.screens.tab.ProfileTab
import com.example.fakepizza.ui.theme.SelectedColor
import com.example.fakepizza.ui.theme.UnselectedColor

@Suppress("ktlint:standard:function-naming")
@Composable
fun MainScreen() {
    TabNavigator(tab = MenuTab) {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                ) {
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
    val isSelected = tabNavigator.current == tab
    BottomNavigationItem(
        selected = isSelected,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let {
                Icon(
                    modifier =
                        Modifier
                            .size(24.dp),
                    painter = it,
                    contentDescription = tab.options.title,
                    tint = if (isSelected) SelectedColor else UnselectedColor,
                )
            }
        },
        label = {
            Text(
                text = tab.options.title,
                color = if (isSelected) SelectedColor else UnselectedColor,
                fontSize = 12.sp,
            )
        },
    )
}
