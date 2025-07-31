package com.example.core.designsystem.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.core.designsystem.resource.font_18
import com.example.core.designsystem.theme.blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    modifier: Modifier = Modifier,
    title: String
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = font_18,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = Color.White,
            containerColor = blue
        )
    )
}