@file:OptIn(ExperimentalMaterial3Api::class)

package com.frigo.frigo.ui.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import com.frigo.frigo.data.DefaultDataRepository
import com.frigo.frigo.theme.FrigoTheme
import com.frigo.frigo.ui.navigationBar.NavigationBar

@Composable
fun MainScreen(
    onItemClick: (NavKey) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = viewModel { MainScreenViewModel(DefaultDataRepository()) },
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    when (state) {
        MainScreenUiState.Loading -> {
            // Blank
        }

        is MainScreenUiState.Success -> {
            MainScreen(data = (state as MainScreenUiState.Success).data, modifier = modifier)
        }

        is MainScreenUiState.Error -> {
            Text("Error loading data: ${(state as MainScreenUiState.Error).throwable.message}")
        }
    }
}

@Composable
internal fun MainScreen(data: List<String>, modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text("name")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Settings, contentDescription = "settings")
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = { NavigationBar.navbar() }
    ) { values ->
        LazyColumn(modifier.fillMaxSize()) {
            items(100) {
                Row {
                    greeting("cum", modifier)
                    greeting("sborra", modifier)
                }
            }
        }
    }
}

@Composable
fun greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FrigoTheme { MainScreen(listOf("Android")) }
}

@Preview(showBackground = true, widthDp = 340)
@Composable
fun MainScreenPortraitPreview() {
    FrigoTheme { MainScreen(listOf("Android")) }
}
