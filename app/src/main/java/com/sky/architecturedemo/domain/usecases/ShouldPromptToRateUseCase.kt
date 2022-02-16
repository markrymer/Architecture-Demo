package com.sky.architecturedemo.domain.usecases

import com.sky.architecturedemo.domain.models.RateMeModel
import com.sky.architecturedemo.domain.repositories.ConfigurationRepository
import com.sky.architecturedemo.domain.repositories.RateMeRepository
import javax.inject.Inject

class ShouldPromptToRateUseCase
@Inject constructor(
    private val rateMeRepository: RateMeRepository,
    private val configurationRepository: ConfigurationRepository
) {

    fun buildUseCase(): RateMeModel {
        val configurationModel = configurationRepository.getConfiguration()
        val launchCount = rateMeRepository.getAppLaunchCount()
        val shouldPrompt = configurationModel.isRateMeEnabled && (launchCount > 0 && launchCount % 5 == 0)
        return RateMeModel(
            shouldPrompt = shouldPrompt
        )
    }
}
