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
}