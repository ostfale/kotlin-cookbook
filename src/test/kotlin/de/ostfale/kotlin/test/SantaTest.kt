package de.ostfale.kotlin.test

import io.mockk.*
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://kotlin.christmas/2020/12

@DisplayName("Test examples for mockk")
internal class SantaTest {

    private val santa = Santa("Olaf", "Meier")

    @Test
    @DisplayName("Use mockk object")
    internal fun useMockObject() {
        // given
        val santaMock = mockk<Santa>()
        // when
        every { santaMock.title } returns "Saint"
        every { santaMock.name } returns "Nicholas"
        every { santaMock.getTitleAndName() } returns "Sinterklaas"
        every { santaMock.laugh(any()) } returns "Ho ho ho!"
        // then
        assertEquals("Saint", santaMock.title)
        assertEquals("Nicholas", santaMock.name)
        assertEquals("Sinterklaas", santaMock.getTitleAndName())
        assertEquals("Ho ho ho!", santaMock.laugh(1))
    }

    @Test
    @DisplayName("Use mockk function")
    internal fun useMockFunction() {
        // given
        val santaMock: Santa = mockk {
            every { title } returns "Saint"
            every { name } returns "Nicholas"
            every { getTitleAndName() } returns "Sinterklaas"
            every { laugh(any()) } returns "Ho ho ho!"
        }
        // then
        assertEquals("Saint", santaMock.title)
        assertEquals("Nicholas", santaMock.name)
        assertEquals("Sinterklaas", santaMock.getTitleAndName())
        assertEquals("Ho ho ho!", santaMock.laugh(1))
    }

    @Test
    @DisplayName("Show argument matching")
    internal fun argumentMatching() {
        // when
        val santaMock: Santa = mockk {
            every { laugh(more(10)) } returns "Many ho's"
            every { laugh(less(1)) } returns "No ho's"
            every { laugh(eq(3)) } returns "Exactly three ho's"
            every { laugh(or(1, 2)) } returns "One or two ho's"
        }
        // then
        assertEquals("Many ho's", santaMock.laugh(11))
        assertEquals("No ho's", santaMock.laugh(0))
        assertEquals("Exactly three ho's", santaMock.laugh(3))
        assertEquals("One or two ho's", santaMock.laugh(2))
    }

    @Test
    @DisplayName("Create sequence of answers")
    internal fun expectedAnswers() {
        // when
        val santaMock: Santa = mockk {
            // These following two lines do the same thing.
            every { laugh(any()) } returnsMany listOf("First ho", "Second Ho")
            every { laugh(any()) } returns "First ho" andThen "Second ho"
        }
        // then
        assertEquals("First ho", santaMock.laugh(11))
        assertEquals("Second ho", santaMock.laugh(11))
    }

    @Test
    @DisplayName("Check Unit runs")
    internal fun testUnitFunction() {
        // when
        val santaMock: Santa = mockk {
            every { functionReturningUnit() } just runs
        }
        // then
        santaMock.functionReturningUnit()
        verify { santaMock.functionReturningUnit() }
    }

    @Test
    @DisplayName("Check an expected exception")
    internal fun testThrowingException() {
        // when
        val santaMock: Santa = mockk {
            every { laugh(more(9000)) } throws LaughTooHardException("Ridiculous, no one laughs for this long.")
        }
        // then
        assertThrows(LaughTooHardException::class.java) {
            santaMock.laugh(9001)
        }
    }

}

class LaughTooHardException(s: String) : RuntimeException()
