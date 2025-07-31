package com.example.feature.home.redux

import com.example.core.model.Profile
import com.example.redux.Action

sealed class HomeActions : Action {
    data object FetchData : HomeActions()
    data class Loaded(val profile: Profile) : HomeActions()

    data class TabIndex(val index: Int) : HomeActions()
}