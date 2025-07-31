package com.example.feature.followers

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.model.Followers
import com.example.feature.followers.component.FollowersItem

@Composable
fun FollowerScreen(
    modifier: Modifier = Modifier,
    list: List<Followers>
) {
    LazyColumn {
        items(list.size) { index ->
            FollowersItem(
                modifier = modifier,
                list[index]
            )
        }
    }

}