package com.example.feature.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.core.designsystem.component.CustomAppBar
import com.example.core.designsystem.component.CustomTabBar
import com.example.core.designsystem.component.LoadingIndicator
import com.example.core.designsystem.resource.font_16
import com.example.core.designsystem.resource.size_5
import com.example.feature.home.R
import com.example.feature.home.Tabs
import com.example.feature.home.navigation.AppNav
import com.example.feature.home.viewmodel.HomeViewModel
import com.example.feature.home.viewmodel.UIEvent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val tabState by viewModel.tabState.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = Color.White, topBar = {
            CustomAppBar(
                title = stringResource(R.string.title)
            )
        }) { innerPadding ->
        if (uiState.loading) {
            Box(
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                LoadingIndicator(
                    modifier = modifier.align(alignment = Alignment.Center)
                )
            }
        } else {
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                CustomTabBar(
                    selectedIndex = tabState.index,
                    tabs = {
                        Tabs.entries.forEachIndexed { index, tabs ->
                            Tab(
                                selected = true,
                                onClick = {
                                    viewModel.event(UIEvent.TabIndex(index))
                                    navController.navigate(route = tabs.route)
                                }
                            ) {
                                Text(
                                    modifier = modifier.padding(bottom = size_5),
                                    text = stringResource(tabs.title),
                                    style = TextStyle(
                                        fontSize = font_16
                                    )
                                )
                            }
                        }
                    }
                )
                AppNav(
                    navHostController = navController as NavHostController,
                    modifier = modifier,
                    profile = uiState.profile
                )
            }
        }
    }
}