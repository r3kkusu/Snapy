package com.snapy.app.data.remote

import com.snapy.app.common.Constants
import com.snapy.app.data.remote.dto.UserDto
import retrofit2.http.*


interface SnapyApi {

    companion object {
        const val BASE_URL_VERSION = "${Constants.BASE_URL}/api/v1"
    }

    @FormUrlEncoded
    @POST("$BASE_URL_VERSION/users/validate")
    suspend fun signIn(
        @Field("username") username: String,
        @Field("password") password: String) : String

    @GET("$BASE_URL_VERSION/users/all")
    suspend fun getAll() : List<UserDto>
}