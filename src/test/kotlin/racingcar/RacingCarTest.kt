package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import utils.InputValidator.checkCarName
import utils.InputValidator.checkRoundCnt

class RacingCarTest {

    @Test
    fun When_CarNamesWithCommaDelimiter_Expect_ValidList() {
        val input = "pobi,woni,jun"
        val expected = listOf("pobi", "woni", "jun")
        val processor = UserInputReader()
        val result = processor.setCarNameList(input)
        assertEquals(expected, result)
    }

    @Test
    fun When_InputSingleCarName_Expect_ValidList() {
        val input = "pobi"
        val expected = listOf("pobi")
        val processor = UserInputReader()
        val result = processor.setCarNameList(input)
        assertEquals(expected, result)
    }

    @Test
    fun When_InputCarNameLengthLessThanOrEqualTo5_Expect_Valid() {
        val input = listOf("pobi", "woni", "jun")
        assertDoesNotThrow { checkCarName(input) }
    }

    @Test
    fun When_InputCarNameLengthExceed5_Expect_Invalid() {
        val input = listOf("yehyun", "woni", "jun")
        assertThrows<IllegalArgumentException> { checkCarName(input) }
    }

    @Test
    fun When_InputIntegerForRoundCount_Expect_Valid() {
        val input = "4"
        assertDoesNotThrow { checkRoundCnt(input) }
    }

    @Test
    fun When_InputNonIntegerForRoundCount_Expect_Invalid() {
        val input = "hello"
        assertThrows<IllegalArgumentException> { checkRoundCnt(input) }
    }

    @Test
    fun When_DifferentDistances_CarsList_Expect_WinnerCar() {
        val input = listOf(Car("pobi", 3), Car("woni", 4), Car("jun", 7))
        val expected = listOf(Car("jun", 7))
        val processor = Race(input)
        val result = processor.findWinner()
        assertEquals(expected, result)
    }

    @Test
    fun When_SameDistances_CarsList_Expect_AllMaxDistanceCars() {
        val input = listOf(Car("pobi", 3), Car("woni", 7), Car("jun", 7))
        val expected = listOf(Car("woni", 7), Car("jun", 7))
        val processor = Race(input)
        val result = processor.findWinner()
        assertEquals(expected, result)
    }
}