package com.sky.architecturedemo.di

import android.content.SharedPreferences
import com.sky.architecturedemo.data.ConfigurationClient
import com.sky.architecturedemo.data.ConfigurationRepositoryImpl
import com.sky.architecturedemo.data.RateMeRepositoryImpl
import com.sky.architecturedemo.data.mappers.ConfigurationDtoDataToDomainMapper
import com.sky.architecturedemo.domain.repositories.ConfigurationRepository
import com.sky.architecturedemo.domain.repositories.RateMeRepository
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

    @Provides
    @Singleton
    fun provideConfigurationRepository(configurationClient: ConfigurationClient, mapper: ConfigurationDtoDataToDomainMapper): ConfigurationRepository {
        return ConfigurationRepositoryImpl(configurationClient, mapper)
    }
}
