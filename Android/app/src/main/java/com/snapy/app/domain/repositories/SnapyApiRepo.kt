package com.snapy.app.domain.repositories

import com.snapy.app.data.remote.dto.UserDto

interface SnapyApiRepo {
    suspend fun signIn(username: String, password: String): String

    suspend fun getAll(): List<UserDto>
}