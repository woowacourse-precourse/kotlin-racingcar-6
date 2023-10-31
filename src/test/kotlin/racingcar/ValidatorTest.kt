package racingcar

import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    private val validator = Validator()

    @Test
    fun `checkHasNoBlank 메서드 사용 시 입력값에 공백이 있을 때 예외 발생`() {
        val input = "A  B"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.checkHasNoBlank(input)
            }
        }
    }

    @Test
    fun `checkHasSeparator 메서드 사용 시 입력값이 separator 로 구분되어 있지 않을 때 예외 발생`() {
        val separator = "ㅤ"   // not space, 공백 특수문자 'ㅤ'
        val input = "A" + separator + "B"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.checkHasSeparator(input, BLANK)
            }
        }
    }

    @Test
    fun `checkHasOnlyDigit 메서드 사용 시 입력값에 정수가 아닌 다른 값이 들어있을 때 예외 발생`() {
        val input = "12a"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.checkHasOnlyDigit(input)
            }
        }
    }

    @Test
    fun `checkItemsHasNoDuplication 메서드 사용 시 입력값에 중복되는 item 이 존재할 때 예외 발생`() {
        val input = listOf(1, 2, 3, 1)

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.checkItemsHasNoDuplication(input)
            }
        }
    }

    @Test
    fun `checkNumericValueIsInBoundary 메서드 사용 시 입력값이 주어진 범위를 벗어났을 때 예외 발생`() {
        val input = 5

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.checkNumericValueIsInBoundary(input, 10, 15)
            }
        }
    }

    companion object {
        private const val BLANK = " "
    }
}