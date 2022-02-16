package com.sky.architecturedemo.data

import com.sky.architecturedemo.data.mappers.ConfigurationDtoDataToDomainMapper
import com.sky.architecturedemo.domain.models.ConfigurationModel
import com.sky.architecturedemo.domain.repositories.ConfigurationRepository
import javax.inject.Inject

class ConfigurationRepositoryImpl
@Inject constructor(
    private val configurationClient: ConfigurationClient,
    private val mapper: ConfigurationDtoDataToDomainMapper
) : ConfigurationRepository {

    override fun getConfiguration(): ConfigurationModel {
        val configDto = configurationClient.getConfigurationDto()
        return mapper(configDto)
    }
}
