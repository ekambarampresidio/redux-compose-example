package com.example.core.common.di

import com.example.core.common.AppDispatchers
import com.example.core.common.CustomDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {


    @Provides
    @AppDispatchers(CustomDispatchers.IO)
    fun providersIODispatchers(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @AppDispatchers(CustomDispatchers.Main)
    fun providersMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @AppDispatchers(CustomDispatchers.Default)
    fun providesDefaultDispatchers(): CoroutineDispatcher = Dispatchers.Default
}