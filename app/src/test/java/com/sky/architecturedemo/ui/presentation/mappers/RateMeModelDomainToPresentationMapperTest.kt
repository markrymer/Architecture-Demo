package com.sky.architecturedemo.ui.presentation.mappers

import com.sky.architecturedemo.R
import com.sky.architecturedemo.domain.models.RateMeModel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class RateMeModelDomainToPresentationMapperTest {

    private val cut = RateMeModelDomainToPresentationMapper()

    @Test
    fun `given invoked with domain model when mapping then return expected ui model`() {
        // Given
        val model = mock<RateMeModel> {
            on { shouldPrompt } doReturn true
        }

        // When
        val result = cut(model)

        // Then
        with(result) {
            assertEquals(model.shouldPrompt, shouldPrompt)
            assertEquals(R.string.rate_me_message, messageResourceId)
        }
    }
}
