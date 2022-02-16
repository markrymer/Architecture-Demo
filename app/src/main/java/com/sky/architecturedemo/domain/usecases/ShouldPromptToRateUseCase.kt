package com.sky.architecturedemo.domain.usecases

import com.sky.architecturedemo.domain.models.RateMeModel
import com.sky.architecturedemo.domain.repositories.RateMeRepository
import javax.inject.Inject

class ShouldPromptToRateUseCase
@Inject constructor(
    private val rateMeRepository: RateMeRepository
) {

    fun buildUseCase(): RateMeModel {
        val launchCount = rateMeRepository.getAppLaunchCount()
        val shouldPrompt = launchCount > 0 && launchCount % 5 == 0
        return RateMeModel(
            shouldPrompt = shouldPrompt
        )
    }
}
