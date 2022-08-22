package com.snapy.app.di

import com.snapy.app.data.repositories.SnapyApiRepoImpl
import com.snapy.app.domain.repositories.SnapyApiRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSnapyApiRepo(
        snapyApiRepoImpl: SnapyApiRepoImpl
    ): SnapyApiRepo
}