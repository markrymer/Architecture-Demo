package com.sky.architecturedemo.ui.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.sky.domain.models.RateMeModel
import com.sky.domain.usecases.AppHasLaunchedUseCase
import com.sky.domain.usecases.ShouldPromptToRateUseCase
import com.sky.architecturedemo.ui.presentation.mappers.RateMeModelDomainToPresentationMapper
import com.sky.architecturedemo.ui.presentation.uiModels.RatingPromptUiModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class MainViewModelTest {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var appHasLaunchedUseCase: AppHasLaunchedUseCase

    @Mock
    private lateinit var shouldPromptToRateUseCase: ShouldPromptToRateUseCase

    @Mock
    private lateinit var rateMeModelDomainToPresentationMapper: RateMeModelDomainToPresentationMapper

    @Mock
    private lateinit var uiStateObserver: Observer<RatingPromptUiModel>

    private lateinit var cut: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        cut = MainViewModel(
            appHasLaunchedUseCase,
            shouldPromptToRateUseCase,
            rateMeModelDomainToPresentationMapper
        )
        cut.shouldPromptLiveData.observeForever(uiStateObserver)
    }

    @Test
    fun `when app launched then update launch status and post expected ui model to presentation`() {
        // Given
        val rateMeModel = mock<RateMeModel> {
            on { shouldPrompt } doReturn false
        }
        whenever(shouldPromptToRateUseCase.buildUseCase()).thenReturn(rateMeModel)

        val uiModel = mock<RatingPromptUiModel>()
        whenever(rateMeModelDomainToPresentationMapper.invoke(rateMeModel)).thenReturn(uiModel)

        // When
        cut.onAppLaunched()

        // Then
        verify(appHasLaunchedUseCase).buildUseCase()
        verify(uiStateObserver).onChanged(uiModel)
    }
}
