package com.example.core.model

data class Profile(
    val posts: List<Posts> = emptyList(),
    val followers: List<Followers> = emptyList(),
    val following: List<Following> = emptyList()
)
