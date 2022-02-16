package com.sky.architecturedemo.data.mappers

import com.sky.architecturedemo.data.models.ConfigurationDto
import com.sky.architecturedemo.domain.models.ConfigurationModel
import javax.inject.Inject

class ConfigurationDtoDataToDomainMapper @Inject constructor() {

    operator fun invoke(configurationDto: ConfigurationDto): ConfigurationModel {
        with(configurationDto) {
            return ConfigurationModel(
                isRateMeEnabled = isRateMeEnabled
            )
        }
    }
}
