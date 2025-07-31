package com.example.core.data.di

import com.example.core.data.DataRepository
import com.example.core.data.DataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindRepository(impl: DataRepositoryImpl): DataRepository
}