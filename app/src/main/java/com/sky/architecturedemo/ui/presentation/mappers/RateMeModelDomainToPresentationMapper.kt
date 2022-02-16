package com.sky.architecturedemo.ui.presentation.mappers

import com.sky.architecturedemo.R
import com.sky.architecturedemo.domain.models.RateMeModel
import com.sky.architecturedemo.ui.presentation.uiModels.RatingPromptUiModel
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
