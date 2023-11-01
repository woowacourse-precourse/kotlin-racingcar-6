package validationTest


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.validation.CheckValidation
import java.lang.IllegalArgumentException

class RacingCountValidationTest {
    private val discriminator = CheckValidation()

    @Test
    fun `레이싱 시도 횟수 유효성 검사`() {
        val input = "5"
        val result = discriminator.checkInputRacingCount(input)
        assertThat(result)
    }

    @Test
    fun `사용자의 입력이 정수가 아닌 경우 예외 발생`() {
        val input = "다섯"
        assertThrows<IllegalArgumentException>("올바른 숫자를 입력해야 합니다.") {
            discriminator.checkInputRacingCount(input)
        }
    }

    @Test
    fun `사용자의 입력이 0인 경우 예외 발생`() {
        val input = "0"
        assertThrows<IllegalArgumentException>("양의 정수를 입력해야 합니다.") {
            discriminator.checkInputRacingCount(input)
        }
    }

    @Test
    fun `사용자의 입력이 음의 정수인 경우 예외 발생`() {
        val input = "-5"
        assertThrows<IllegalArgumentException>("양의 정수를 입력해야 합니다.") {
            discriminator.checkInputRacingCount(input)
        }
    }
}