package com.example.core.database

import com.example.core.model.Followers
import com.example.core.model.Following
import com.example.core.model.Posts
import com.example.core.model.Profile

private val followers = List(20) { index ->
    Followers(
        name = "Follower ${index + 1}",
        date = "2025-07-${10 + index}",
        content = "Really love your content on topic ${index + 1}!"
    )
}

private val following = List(20) { index ->
    Following(
        name = "Following ${index + 1}",
        date = "2025-06-${5 + index}",
        content = "Following for updates on Compose and Kotlin."
    )
}

private val posts = List(20) { index ->
    Posts(
        title = "Post Title ${index + 1}",
        date = "2025-07-${(10 + index).coerceAtMost(30)}",
        content = "This is the detailed content of post number ${index + 1}, describing a concept in Android or Kotlin development."
    )
}

internal val profile = Profile(
    posts = posts,
    followers = followers,
    following = following
)