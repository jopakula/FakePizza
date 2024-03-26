package com.example.fakepizza.ui.screens.tab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.fakepizza.R

class MenuScreen : Screen {
    @Composable
    override fun Content() {
        var expanded by remember { mutableStateOf(false) }
        var selectedCity by remember { mutableStateOf("Москва") }
        val cities = listOf("Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань", "Тверь")

        Column(
            modifier =
                Modifier
                    .fillMaxSize(),
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(modifier = Modifier.weight(1F)) {
                    ClickableText(
                        text = AnnotatedString(selectedCity),
                        onClick = { expanded = true },
                    )
                    Icon(
                        modifier =
                            Modifier
                                .clickable { expanded = true },
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowRight,
                        contentDescription = null,
                    )
                    DropdownMenu(
                        modifier =
                            Modifier
                                .weight(1F),
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                    ) {
                        cities.forEach { city ->
                            DropdownMenuItem(
                                text = { Text(text = city) },
                                onClick = {
                                    selectedCity = city
                                    expanded = false
                                },
                            )
                        }
                    }
                }
                Icon(painter = painterResource(id = R.drawable.icon_qr_code), contentDescription = null)
            }
        }
    }
}
