package com.example.redux

typealias Reducer<State> = ReducerType<State, Action>

typealias ReducerType<State, Action> = (state: State, action: Action) -> State

inline fun <State, reified Action> createReducer(
    crossinline reducer: ReducerType<State, Action>
): Reducer<State> = { state, action ->
    when(action) {
        is Action -> reducer(state, action)
        else -> state
    }
}