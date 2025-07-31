package com.example.feature.home.extension

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


fun <T, M> StateFlow<T>.map(
    scope: CoroutineScope,
    started: SharingStarted = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
    mapper: (T) -> M
): StateFlow<M> = map { mapper(it) }.stateIn(
    scope = scope,
    started,
    initialValue = mapper(value)
)