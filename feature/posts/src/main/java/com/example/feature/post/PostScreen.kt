package com.example.feature.post

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.model.Posts
import com.example.feature.post.component.PostItem

@Composable
fun PostScreen(
    modifier: Modifier = Modifier,
    posts: List<Posts>
) {
    LazyColumn {
        items(posts.size) { index ->
            PostItem(
                modifier = modifier,
                posts[index]
            )
        }
    }
}
