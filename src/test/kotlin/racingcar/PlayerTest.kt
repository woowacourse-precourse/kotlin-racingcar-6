package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.validator.StringValidator

class PlayerTest {

    @Test
    fun `determineCarNames는 input(String)을 받고, carNames(String 리스트)로 변환한다`() {
        val input = "june,crong,pobi"
        val player = Player()

        val carNames = player.determineCarNames(input)

        assertThat(carNames)
            .isEqualTo(listOf("june", "crong", "pobi"))
    }

    @Test
    fun `determineCarNames는 다른 방식으로 유효성을 검사할 수 있다`() {
        val inputName = "june"
        val player = Player()

        assertThrows<IllegalArgumentException>("Car 이름이 3글자 미만이여야 합니다") {
            player.determineCarNames(inputName, object : StringValidator {
                override fun validate(input: String) {
                    if (input.length > 3) {
                        throw IllegalArgumentException("Car 이름이 3글자 미만이여야 합니다")
                    }
                }
            })
        }
    }

    @Test
    fun `determineAttemptCount는 input을 받고, int값으로 변환한다`() {
        val input = "5"
        val player = Player()

        val attemptCount = player.determineAttemptCount(input)

        assertThat(attemptCount).isEqualTo(5)
    }

    @Test
    fun `determineAttemptCount는는 다른 방식으로 유효성을 검사할 수 있다`() {
        val inputName = "1a"
        val player = Player()

        assertThrows<IllegalArgumentException>("Car 이름이 3글자 미만이여야 합니다") {
            player.determineCarNames(inputName, object : StringValidator {
                override fun validate(input: String) {
                    if (input[1].isLetter()) {
                        throw IllegalArgumentException("Car 이름이 3글자 미만이여야 합니다")
                    }
                }
            })
        }
    }
}