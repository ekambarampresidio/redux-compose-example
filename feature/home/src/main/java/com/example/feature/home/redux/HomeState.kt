package com.example.feature.home.redux

import com.example.core.model.Profile

data class HomeState(
    val loading: Boolean = false,
    val profile: Profile? = null,
    val tabIndex: Int = 0
)