package racingcar.domain

import org.junit.jupiter.api.*

class RoundNumberTest {

    private lateinit var roundNumber: RoundNumber

    @BeforeEach
    fun setUp(){
        roundNumber = RoundNumber()
    }

    @Test
    fun `입력값이 없을 때`() {
        val input = ""
        val exception = assertThrows<IllegalArgumentException> {
            roundNumber.validateInput(input)
        }
        Assertions.assertEquals(RoundNumberConstants.INPUT_IS_EMPTY, exception.message)
    }

    @Test
    fun `입력값이 문자일 때`() {
        val input = "woowa"
        val exception = assertThrows<IllegalArgumentException> {
            roundNumber.validateInput(input)
        }
        Assertions.assertEquals(RoundNumberConstants.INPUT_IS_NOT_INT, exception.message)
    }

    @Test
    fun `입력값이 양수로 정수 범위를 초과할 때`() {
        val input = "2147483648"
        val exception = assertThrows<IllegalArgumentException> {
            roundNumber.validateInput(input)
        }
        Assertions.assertEquals(RoundNumberConstants.INPUT_IS_NOT_INT, exception.message)
    }

    @Test
    fun `입력값이 음수로 정수 범위를 초과할 때`() {
        val input = "-2147483649"
        val exception = assertThrows<IllegalArgumentException> {
            roundNumber.validateInput(input)
        }
        Assertions.assertEquals(RoundNumberConstants.INPUT_IS_NOT_INT, exception.message)
    }

    @Test
    fun `입력값이 0일 때`() {
        val input = "0"
        val exception = assertThrows<IllegalArgumentException> {
            roundNumber.validateInput(input)
        }
        Assertions.assertEquals(RoundNumberConstants.ROUND_NUMBER_IS_NOT_POSITIVE, exception.message)
    }

    @Test
    fun `입력값이 음수인 정수일 때`() {
        val input = "-2147483648"
        val exception = assertThrows<IllegalArgumentException> {
            roundNumber.validateInput(input)
        }
        Assertions.assertEquals(RoundNumberConstants.ROUND_NUMBER_IS_NOT_POSITIVE, exception.message)
    }

    @Test
    fun `입력값이 양수인 정수일 때`() {
        val input = "2147483647"
        assertDoesNotThrow {
            roundNumber.validateInput(input)
        }
    }

}