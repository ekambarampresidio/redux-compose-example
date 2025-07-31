package com.example.feature.home.redux

import com.example.redux.Reducer
import com.example.redux.createReducer

val homeReducer: Reducer<HomeState> = createReducer<HomeState, HomeActions> { state, action ->
    when (action) {
        is HomeActions.FetchData -> state.copy(loading = true)
        is HomeActions.Loaded -> state.copy(loading = false, profile = action.profile)
        is HomeActions.TabIndex -> state.copy(tabIndex = action.index)
    }
}