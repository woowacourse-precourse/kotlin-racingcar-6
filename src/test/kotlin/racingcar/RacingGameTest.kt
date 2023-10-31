package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `test getTryCount with valid input`() {

        val input = "5"
        System.setIn(input.byteInputStream())

        val tryCount = getTryCount()

        assertEquals(5, tryCount)
    }

    @Test
    fun `test getTryCount with invalid input`() {

        val input = "invalid"
        System.setIn(input.byteInputStream())

    }
}