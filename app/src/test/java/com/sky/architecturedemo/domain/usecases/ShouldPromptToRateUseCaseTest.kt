package com.sky.architecturedemo.domain.usecases

import com.sky.architecturedemo.domain.repositories.RateMeRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

@RunWith(Parameterized::class)
class ShouldPromptToRateUseCaseTest(
    private val numberOfLaunches: Int,
    private val expectedShouldShowPrompt: Boolean
) {

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "Number of launches {0} Expected should prompt {1}")
        fun data(): List<Array<Any?>> {
            return listOf(
                arrayOf(0, false),
                arrayOf(1, false),
                arrayOf(2, false),
                arrayOf(3, false),
                arrayOf(4, false),
                arrayOf(5, true),
                arrayOf(6, false),
                arrayOf(7, false),
                arrayOf(8, false),
                arrayOf(9, false),
                arrayOf(10, true)
            )
        }
    }

    @Mock
    private lateinit var rateMeRepository: RateMeRepository

    private lateinit var cut: ShouldPromptToRateUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        cut = ShouldPromptToRateUseCase(rateMeRepository)
    }

    @Test
    fun `given number of launches when build use case then return expected should show prompt`() {
        // Given
        whenever(rateMeRepository.getAppLaunchCount()).thenReturn(numberOfLaunches)

        // When
        val result = cut.buildUseCase()

        // Then
        assertEquals(expectedShouldShowPrompt, result.shouldPrompt)
    }
}
