package com.example.core.common

import javax.inject.Qualifier

enum class CustomDispatchers {
    IO,
    Default,
    Main
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppDispatchers(val dispatcher: CustomDispatchers)