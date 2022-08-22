package com.snapy.app.di

import com.snapy.app.common.Constants
import com.snapy.app.data.remote.SnapyApi
import com.snapy.app.domain.repositories.SnapyApiRepo
import com.snapy.app.domain.usecase.AuthUseCase
import com.snapy.app.domain.usecase.queries.ValidateAccount
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMovieApi(): SnapyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
            .build()
            .create(SnapyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthUseCase(
        apiRepo: SnapyApiRepo
    ): AuthUseCase {
        return AuthUseCase(
            validate = ValidateAccount(apiRepo)
        )
    }
}