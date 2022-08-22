package com.snapy.app.data.repositories

import com.snapy.app.data.remote.SnapyApi
import com.snapy.app.data.remote.dto.UserDto
import com.snapy.app.domain.repositories.SnapyApiRepo
import javax.inject.Inject

class SnapyApiRepoImpl @Inject constructor(
    private val api: SnapyApi
) :  SnapyApiRepo {

    private val TAG = "SnapyApiRepoImpl"

    override suspend fun signIn(username: String, password: String): String {
        return api.signIn(username, password)
    }

    override suspend fun getAll(): List<UserDto> {
        return api.getAll()
    }
}