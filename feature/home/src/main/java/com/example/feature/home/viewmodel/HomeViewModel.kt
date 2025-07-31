package com.example.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common.AppDispatchers
import com.example.core.common.CustomDispatchers
import com.example.core.common.di.ApplicationScope
import com.example.core.data.DataRepository
import com.example.core.model.Profile
import com.example.feature.home.extension.map
import com.example.feature.home.redux.HomeActions
import com.example.feature.home.redux.HomeState
import com.example.feature.home.redux.createHomeMiddleware
import com.example.feature.home.redux.homeReducer
import com.example.redux.applyMiddleware
import com.example.redux.createAnyStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DataRepository,
    @AppDispatchers(CustomDispatchers.IO) dispatcher: CoroutineDispatcher,
    @ApplicationScope scope: CoroutineScope
) : ViewModel() {

    private val store = createAnyStore(
        reducer = homeReducer,
        initialState = HomeState(),
        storeEnhancer = applyMiddleware(
            listOf(
                createHomeMiddleware(
                    repository, scope = CoroutineScope(scope.coroutineContext + dispatcher)
                )
            )
        )
    )

    init {
        event(UIEvent.FetchData)
    }

    val tabState: StateFlow<TapInput> = store.stateFlow.map(
        scope = viewModelScope, mapper = { homeState ->
            TapInput(
                index = homeState.tabIndex
            )
        })

    val uiState: StateFlow<UIState> = store.stateFlow.map(
        scope = viewModelScope,
        mapper = { homeState ->
            UIState(
                loading = homeState.loading,
                profile = homeState.profile ?: Profile()
            )
        }
    )

    fun event(event: UIEvent) {
        when (event) {
            is UIEvent.FetchData -> store.dispatch(HomeActions.FetchData)
            is UIEvent.TabIndex -> {
                store.dispatch(HomeActions.TabIndex(event.index))
            }
        }
    }
}

data class TapInput(var index: Int)

data class UIState(
    val loading: Boolean,
    val profile: Profile
)

sealed class UIEvent {
    data object FetchData : UIEvent()
    data class TabIndex(val index: Int) : UIEvent()
}