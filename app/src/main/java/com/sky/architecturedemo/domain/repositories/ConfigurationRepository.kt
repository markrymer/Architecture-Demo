package com.sky.architecturedemo.domain.repositories

import com.sky.architecturedemo.domain.models.ConfigurationModel

interface ConfigurationRepository {

    fun getConfiguration(): ConfigurationModel
}
