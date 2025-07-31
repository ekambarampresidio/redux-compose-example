package com.example.core.data

import com.example.core.model.Profile

interface DataRepository {
    fun getData(): Profile
}