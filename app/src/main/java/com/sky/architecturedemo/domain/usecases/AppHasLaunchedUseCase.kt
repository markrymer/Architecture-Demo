package com.sky.architecturedemo.domain.usecases

import com.sky.architecturedemo.domain.repositories.RateMeRepository
import javax.inject.Inject

class AppHasLaunchedUseCase
@Inject constructor(
    private val rateMeRepository: RateMeRepository
) {

    fun buildUseCase() {
        rateMeRepository.incrementAppHasLaunched()
    }
}
