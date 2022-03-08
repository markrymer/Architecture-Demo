package com.sky.architecturedemo.di

import android.content.SharedPreferences
import com.sky.data.repositories.RateMeRepositoryImpl
import com.sky.domain.repositories.RateMeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRateMeRepository(sharedPreferences: SharedPreferences): RateMeRepository {
        return RateMeRepositoryImpl(sharedPreferences)
    }
}
