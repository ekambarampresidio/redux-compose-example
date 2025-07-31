package com.example.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.core.designsystem.resource.size_05
import com.example.core.designsystem.resource.size_48
import com.example.core.designsystem.resource.size_5
import com.example.core.designsystem.theme.blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTabBar(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    tabs: @Composable () -> Unit
) {
    PrimaryTabRow(
        modifier = modifier
            .height(size_48)
            .fillMaxWidth(),
        selectedTabIndex = selectedIndex,
        containerColor = Color.White,
        contentColor = Color.Black,
        divider = {
        },
        indicator = {
            TabRowDefaults.PrimaryIndicator(
                modifier = Modifier
                    .tabIndicatorOffset(
                        selectedIndex,
                        matchContentSize = true
                    )
                    .padding(bottom = size_05),
                height = size_5,
                width = size_48,
                color = blue
            )
        },
        tabs = tabs,
    )
}
