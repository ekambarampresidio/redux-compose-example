package com.example.feature.home.redux

import com.example.core.data.DataRepository
import com.example.redux.Middleware
import com.example.redux.Store
import com.example.redux.createMiddleware
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun createHomeMiddleware(
    repository: DataRepository,
    scope: CoroutineScope
): Middleware<Any> {
    return createMiddleware { store, next, action ->
        next(action)
        when (action) {
            is HomeActions.FetchData -> loadData(
                repository,
                scope,
                store
            )
        }
    }
}

fun loadData(
    repository: DataRepository,
    scope: CoroutineScope,
    store: Store<Any>
) {
    scope.launch {
        delay(2000)
        store.dispatch(HomeActions.Loaded(repository.getData()))
    }
}