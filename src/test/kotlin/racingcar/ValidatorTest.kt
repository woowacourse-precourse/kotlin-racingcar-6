package racingcar

import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    private val validator = Validator()

    @Test
    fun `validateCarNames 메서드 사용 시 carName 이 쉼표로 구분되어있지 않을 때 예외 발생`() {
        val input = "A B"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateCarNames(input)
            }
        }
    }

    @Test
    fun `validateCarNames 메서드 사용 시 carName 이 공백으로 작성되었을 때 예외 발생`() {
        val input = "A, ,ABC"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateCarNames(input)
            }
        }
    }

    @Test
    fun `validateCarNames 메서드 사용 시 carName 이 5자를 넘어설 때 예외 발생`() {
        val input = "A,ABC,ABCDEF"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateCarNames(input)
            }
        }
    }

    @Test
    fun `validateCarNames 메서드 사용 시 carName 의 개수가 1개일 때 예외 발생`() {
        val input = "ABC"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateCarNames(input)
            }
        }
    }

    @Test
    fun `validateCarNames 메서드 사용 시 중복되는 carName 이 존재할 때 예외 발생`() {
        val input = "A,B,A"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateCarNames(input)
            }
        }
    }

    @Test
    fun `validateCarNames 메서드 사용 시 carName 에 아무런 값을 입력하지 않았을 때 예외 발생`() {
        val input = ""

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateCarNames(input)
            }
        }
    }

    @Test
    fun `validateTotalRoundNumber 메서드 사용 시 totalRoundNumber 가 문자일 때 예외 발생`() {
        val input = "abc"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateTotalRoundNumber(input)
            }
        }
    }

    @Test
    fun `validateTotalRoundNumber 메서드 사용 시 totalRoundNumber 가 정수 타입이 아닐 때 예외 발생`() {
        val input = "1.5"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateTotalRoundNumber(input)
            }
        }
    }

    @Test
    fun `validateTotalRoundNumber 메서드 사용 시 totalRoundNumber 가 1 이상의 값이 아닐 때 예외 발생`() {
        val input = "0"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateTotalRoundNumber(input)
            }
        }
    }

    @Test
    fun `validateTotalRoundNumber 메서드 사용 시 totalRoundNumber 에 아무런 값을 입력하지 않았을 때 예외 발생`() {
        val input = ""

        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validator.validateTotalRoundNumber(input)
            }
        }
    }
}