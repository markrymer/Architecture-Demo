package com.sky.architecturedemo.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sky.domain.usecases.AppHasLaunchedUseCase
import com.sky.domain.usecases.ShouldPromptToRateUseCase
import com.sky.architecturedemo.presentation.mappers.RateMeModelDomainToPresentationMapper
import com.sky.architecturedemo.presentation.uiModels.RatingPromptUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val appHasLaunchedUseCase: AppHasLaunchedUseCase,
    private val shouldPromptToRateUseCase: ShouldPromptToRateUseCase,
    private val rateMeModelDomainToPresentationMapper: RateMeModelDomainToPresentationMapper
) : ViewModel() {

    internal val shouldPromptLiveData: MutableLiveData<RatingPromptUiModel> = MutableLiveData()

    fun onAppLaunched() {
        appHasLaunchedUseCase.buildUseCase()
        shouldPromptToRateUseCase.buildUseCase()
            .let { domainModel ->
                val uiModel = rateMeModelDomainToPresentationMapper(domainModel)
                shouldPromptLiveData.postValue(uiModel)
            }
    }
}
