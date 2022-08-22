package com.snapy.app.domain.usecase.queries

import com.snapy.app.common.Resource
import com.snapy.app.domain.repositories.SnapyApiRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ValidateAccount @Inject constructor(
    private val snapyApiRepo: SnapyApiRepo
) {
    operator fun invoke(username: String, password: String) : Flow<Resource<String>> {
        return flow {
            emit(Resource.Loading(true))
            val remoteUser = try {
                snapyApiRepo.signIn(username, password)
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
            remoteUser?.let { it -> emit(Resource.Success(it)) }
            emit(Resource.Loading(false))
        }
    }
}