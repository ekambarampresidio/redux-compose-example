package com.example.redux

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

interface Action

typealias StoreEnhancer<State> = (StoreCreator<State>) -> StoreCreator<State>

typealias StoreCreator<State> = (reducer: Reducer<State>, initialState: State, storeEnhancer: Any?) -> Store<State>

typealias Dispatch = (action: Action) -> Unit

interface Store<State> {
    val state: State
        get() = stateFlow.value
    val stateFlow: StateFlow<State>
    var dispatch: Dispatch
}

fun <State> createStore(
    reducer: Reducer<State>,
    initialState: State,
    enhancer: StoreEnhancer<State>? = null
): Store<State> {
    if (enhancer != null) {
        return enhancer { originalReducer, originalState, _ ->
            createStore(originalReducer, originalState)
        }(reducer, initialState, null)
    }

    val mutableState = MutableStateFlow(initialState)
    val stateFlow: StateFlow<State> = mutableState.asStateFlow()

    fun dispatch(action: Action) {
        mutableState.update { state ->
            reducer(state, action)
        }
    }

    return object : Store<State> {
        override val stateFlow = stateFlow
        override var dispatch: Dispatch = ::dispatch
    }
}

fun <State> createAnyStore(
    reducer: Reducer<State>,
    initialState: State,
    storeEnhancer: StoreEnhancer<Any>? = null
): Store<State> {
    val enhancerType = storeEnhancer as StoreEnhancer<State>
    return createStore(
        reducer, initialState, enhancerType
    )
}