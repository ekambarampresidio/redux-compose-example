package com.example.feature.home

import androidx.annotation.StringRes
import com.example.feature.home.navigation.Route


enum class Tabs(
    @StringRes val title: Int,
    val route: String
) {
    Post(R.string.tab1, Route.POSTS),
    Following(R.string.tab2, Route.FOLLOWING),
    Follower(R.string.tab3, Route.FOLLOWERS)
}