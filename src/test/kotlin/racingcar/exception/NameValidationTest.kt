package racingcar.exception

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameValidationTest {
    @Test
    fun `이름에 공백이 포함돼 있을 때 예외 발생`() {
        val input: List<String> = listOf("minsu ", "mul", " ")
        assertThrows<IllegalArgumentException> {
            input.forEach {
                require(!it.contains(Regex("\\s")))
            }
        }
    }

    @Test
    fun `이름이 공백일 때 예외 발생`() {
        val input = listOf("minsu", "", "susu")
        assertThrows<IllegalArgumentException> {
            input.forEach {
                require(it.isNotBlank())
            }
        }
    }

    @Test
    fun `중복된 이름이 있을 때 예외 발생`() {
        val input = listOf("minsu", "minsu", "mull", "dog")
        assertThrows<IllegalArgumentException> {
            require(input.toSet().size == input.size)
        }
    }

    @Test
    fun `이름이 5자 초과일 때 예외 발생`() {
        val input = listOf("minsu", "afsdsdd", "13")
        assertThrows<IllegalArgumentException> {
            repeat(input.size) {
                require(input[it].length <= MAX_NAME_LENGTH)
            }
        }
    }

    @Test
    fun `값을 입력하지 않았을 때 예외 발생`() {
        val input = ""
        assertThrows<IllegalArgumentException> {
            require(input.isNotEmpty())
        }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}