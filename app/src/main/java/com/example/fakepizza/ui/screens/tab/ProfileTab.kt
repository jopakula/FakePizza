package com.example.fakepizza.ui.screens.tab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.fakepizza.R

object ProfileTab : Tab {
    @Composable
    override fun Content() {
        Box(
            modifier =
                Modifier
                    .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "ProfileTab")
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(id = R.string.person_title)
            val icon = painterResource(id = R.drawable.icon_person)
            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon,
                )
            }
        }
}
