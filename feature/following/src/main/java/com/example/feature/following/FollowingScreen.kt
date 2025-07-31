package com.example.feature.following

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.model.Following
import com.example.feature.following.component.FollowingItem

@Composable
fun FollowingScreen(
    modifier: Modifier = Modifier,
    list: List<Following>
) {
    LazyColumn {
        items(list.size) { index ->
            FollowingItem(
                modifier = modifier,
                list[index]
            )
        }
    }
}