package study

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import util.Validator.inputCarNameCheck
import util.Validator.inputRacingRoundContentCheck
import java.math.BigInteger

class ValidatorTest {
    @Test
    fun `roundCountCheck 입력 받은 라운드 값 유효성 검사`() {
        val firstInput = "1234"
        val firstResult = BigInteger("1234")
        assertThat(firstResult).isEqualTo(inputRacingRoundContentCheck(firstInput))

        val secondInput = "0000"
        assertThrows<IllegalArgumentException> {
            inputRacingRoundContentCheck(secondInput)
        }

        val thirdInput = "125as"
        assertThrows<IllegalArgumentException> {
            inputRacingRoundContentCheck(thirdInput)
        }

        val fourthInput = "32198765498352168431984351984351"
        assertDoesNotThrow {
            inputRacingRoundContentCheck(fourthInput)
        }
    }

    @Test
    fun `carNameCheck 입력 받은 자동차들의 이름 유효성 검사`() {
        val firstInput = "일번,삼번,사번,오번,789번,120"
        assertThat(inputCarNameCheck(firstInput))
            .containsAll(listOf("일번", "삼번", "사번", "오번", "789번", "120"))

        val secondInput = "6549,45612,가나다라마사"
        assertThrows<IllegalArgumentException> {
            inputCarNameCheck(secondInput)
        }

        val thirdInput = "asd,123,,"
        assertThrows<IllegalArgumentException> {
            inputCarNameCheck(thirdInput)
        }
    }
}
