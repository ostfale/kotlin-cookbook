package de.ostfale.kotlin.test

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Examples for verify tests")
internal class VerifyTests {

    @Test
    @DisplayName("Verify all functions called")
    internal fun verifyFunctionCalls() {
        // given
        val santaMock = mockk<Santa>()
        // when
        every { santaMock.name } returns "Nicholas"
        every { santaMock.getTitleAndName() } returns "Sinterklaas"
        every { santaMock.laugh(any()) } returns "Ho ho ho!"
        // then
        santaMock.name
        santaMock.getTitleAndName()
        santaMock.laugh(2)
        verify {
            santaMock.name
            santaMock.getTitleAndName()
            santaMock.laugh(2)
        }
    }

    @Test
    @DisplayName("Verify exact number a function has been called")
    internal fun verifyExactNumber() {
        // given
        val santaMock = mockk<Santa>()
        // when
        every { santaMock.laugh(any()) } returns "Ho ho ho!"
        // then
        santaMock.laugh(1)
        verify(exactly = 1) {
            santaMock.laugh(1)
        }
    }

    @Test
    @DisplayName("Verify interval number a function has been called")
    internal fun verifyIntervalNumber() {
        // given
        val santaMock = mockk<Santa>()
        // when
        every { santaMock.laugh(any()) } returns "Ho ho ho!"
        // then
        santaMock.laugh(1)
        santaMock.laugh(2)
        santaMock.laugh(3)
        verify(atLeast = 2, atMost = 5) {
            santaMock.laugh(any())
        }
    }
}