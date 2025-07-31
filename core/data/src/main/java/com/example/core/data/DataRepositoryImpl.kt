package com.example.core.data

import com.example.core.model.Profile
import javax.inject.Inject

internal  class DataRepositoryImpl @Inject constructor(val profile: Profile) : DataRepository {
    override fun getData(): Profile {
        return profile
    }
}