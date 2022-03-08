package com.sky.architecturedemo.presentation.uiModels

import androidx.annotation.StringRes

data class RatingPromptUiModel(
    val shouldPrompt: Boolean,
    @StringRes val messageResourceId: Int
)
