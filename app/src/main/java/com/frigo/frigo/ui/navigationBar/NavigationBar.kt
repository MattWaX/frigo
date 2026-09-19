package com.frigo.frigo.ui.navigationBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

class NavigationBar {
    companion object {
        @Composable
        fun navbar() {
            var selectedItem by rememberSaveable { mutableIntStateOf(0) }
            val items = listOf("Cookbook", "Fridge", "Calendar")
            val selectedIcons = listOf(Icons.AutoMirrored.Filled.MenuBook, Icons.Filled.Kitchen, Icons.Filled.Dining)
            val unselectedIcons =
                listOf(Icons.AutoMirrored.Outlined.MenuBook, Icons.Outlined.Kitchen, Icons.Outlined.Dining)

            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                                contentDescription = item,
                            )
                        },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                    )
                }
            }
        }
    }
}
