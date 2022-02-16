package com.sky.architecturedemo.data

import com.sky.architecturedemo.data.models.ConfigurationDto
import javax.inject.Inject

class ConfigurationClient @Inject constructor() {

    fun getConfigurationDto(): ConfigurationDto {
        // In reality this would be a retrofit client
        return ConfigurationDto(true)
    }
}
