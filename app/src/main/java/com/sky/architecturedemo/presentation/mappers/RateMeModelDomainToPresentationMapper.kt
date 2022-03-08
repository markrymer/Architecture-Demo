package com.sky.architecturedemo.presentation.mappers

import com.sky.architecturedemo.R
import com.sky.domain.models.RateMeModel
import com.sky.architecturedemo.presentation.uiModels.RatingPromptUiModel
import javax.inject.Inject

class RateMeModelDomainToPresentationMapper
@Inject constructor() {

    operator fun invoke(domainModel: RateMeModel): RatingPromptUiModel {
        return RatingPromptUiModel(
            shouldPrompt = domainModel.shouldPrompt,
            messageResourceId = R.string.rate_me_message
        )
    }
}
