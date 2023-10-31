package util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.util.Exceptions

class ExceptionsTest {
    @Test
    fun `validateCarNamesInput 유효한 입력값이 들어왔을 때 DoesNotThrow`() {
        // Arrange
        val input = "car1, car2, car3"

        // Act and Assert
        assertDoesNotThrow { Exceptions.validateCarNamesInput(input) }
    }

    @Test
    fun `validateCarNamesInput 널값 예외처리`() {
        // Arrange
        val input: String? = null

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exceptions.validateCarNamesInput(input) }
    }

    @Test
    fun `validateCarNamesInput 이름이 없는 자동차가 들어왔을 경우 예외처리`() {
        // Arrange
        val input = "car1, , car3"

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exceptions.validateCarNamesInput(input) }
    }

    @Test
    fun `validateCarNamesInput 5자 이상의 자동차 이름이 들어왔을 경우 예외처리`() {
        // Arrange
        val input = "car1, superlongcarname, car3"

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exceptions.validateCarNamesInput(input) }
    }

    @Test
    fun `validateCarNamesInput 두대 미만의 자동차가 들어왔을 경우 예외처리`() {
        // Arrange
        val input = "car1"

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exceptions.validateCarNamesInput(input) }
    }

    @Test
    fun `validateRoundsInput 유효한 입력이 들어왔을 때 assertDoesNotThrow`() {
        // Arrange
        val input = "5"

        // Act and Assert
        assertDoesNotThrow { Exceptions.validateRoundsInput(input) }
    }

    @Test
    fun `validateRoundsInput 널값 예외처리`() {
        // Arrange
        val input: String? = null

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exceptions.validateRoundsInput(input) }
    }

    @Test
    fun `validateRoundsInput 정수값이 아닌경우 예외처리`() {
        // Arrange
        val input = "abc"

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exceptions.validateRoundsInput(input) }
    }

    @Test
    fun `validateRoundsInput 0이 들어온 경우 예외처리`() {
        // Arrange
        val input = "0"

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exceptions.validateRoundsInput(input) }
    }
}
