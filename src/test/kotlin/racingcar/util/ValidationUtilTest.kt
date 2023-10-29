package racingcar.util

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ValidationUtilTest {

    @Test
    fun `validateCarNames - 자동차 이름이 비어있으면 오류를 발생한다`() {
        val names = listOf("car1", "")
        val exception = assertThrows(IllegalArgumentException::class.java) {
            ValidationUtil.validateCarNames(names)
        }
        assert(exception.message == "자동차 이름은 비어 있을 수 없습니다.")
    }

    @Test
    fun `validateCarNames - 자동차 이름이 5자 이상이면 오류를 발생한다`() {
        val names = listOf("car123")
        val exception = assertThrows(IllegalArgumentException::class.java) {
            ValidationUtil.validateCarNames(names)
        }
        assert(exception.message == "자동차 이름은 5자 이하만 가능합니다.")
    }

    @Test
    fun `validateCarNames - 자동차 이름이 중복되면 오류를 발생한다`() {
        val names = listOf("car1", "car1")
        val exception = assertThrows(IllegalArgumentException::class.java) {
            ValidationUtil.validateCarNames(names)
        }
        assert(exception.message == "자동차 이름은 중복될 수 없습니다.")
    }

    @Test
    fun `validateNumberOfRounds - 시도 횟수가 자연수가 아니면 오류를 발생한다`() {
        val input = "0"
        val exception = assertThrows(IllegalArgumentException::class.java) {
            ValidationUtil.validateNumberOfRounds(input)
        }
        assert(exception.message == "시도 횟수는 자연수로 입력해주세요.")
    }

    @Test
    fun `validateNumberOfRounds - 시도 횟수가 숫자가 아니면 오류를 발생한다`() {
        val input = "abc"
        val exception = assertThrows(IllegalArgumentException::class.java) {
            ValidationUtil.validateNumberOfRounds(input)
        }
        assert(exception.message == "시도 횟수는 자연수로 입력해주세요.")
    }
}
