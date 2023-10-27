package study

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
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
        assertThatIllegalArgumentException().isThrownBy {
            inputRacingRoundContentCheck(secondInput)
        }

        val thirdInput = "125as"
        assertThatIllegalArgumentException().isThrownBy {
            inputRacingRoundContentCheck(thirdInput)
        }

        val fourthInput = "32198765498352168431984351984351"
        assertThatNoException().isThrownBy {
            inputRacingRoundContentCheck(fourthInput)
        }
    }

    @Test
    fun `carNameCheck 입력 받은 자동차들의 이름 유효성 검사`() {
        val firstInput = "일번,삼번,사번,오번,789번"
        assertThat(inputCarNameCheck(firstInput))
            .containsAll(listOf("일번", "삼번", "사번", "오번", "789번"))

        val secondInput = "6549,45612,가나다라마사"
        assertThatIllegalArgumentException().isThrownBy {
            inputCarNameCheck(secondInput)
        }

        val thirdInput = "asd,123,,"
        assertThatIllegalArgumentException().isThrownBy {
            inputCarNameCheck(thirdInput)
        }
    }
}
