package com.sky.domain.usecases

import com.sky.domain.repositories.RateMeRepository
import javax.inject.Inject

class AppHasLaunchedUseCase
@Inject constructor(
    private val rateMeRepository: RateMeRepository
) {

    fun buildUseCase() {
        rateMeRepository.incrementAppHasLaunched()
    }
}
