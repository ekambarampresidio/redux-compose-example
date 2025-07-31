package com.example.feature.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.core.model.Profile
import com.example.feature.followers.FollowerScreen
import com.example.feature.following.FollowingScreen
import com.example.feature.post.PostScreen


@Composable
fun AppNav(
    navHostController: NavHostController,
    modifier: Modifier,
    profile: Profile
) {
    NavHost(
        navController = navHostController,
        startDestination = Route.POSTS,
    ) {
        composable(route = Route.POSTS) {
            PostScreen(modifier = modifier, profile.posts)
        }
        composable(route = Route.FOLLOWERS) {
            FollowerScreen(modifier = modifier, profile.followers)
        }
        composable(route = Route.FOLLOWING) {
            FollowingScreen(modifier = modifier, profile.following)
        }
    }
}