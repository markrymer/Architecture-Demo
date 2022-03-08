package com.sky.domain.usecases

import com.sky.domain.models.RateMeModel
import com.sky.domain.repositories.RateMeRepository
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
