package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
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

        val fourthInput = "12345"
        assertThatIllegalArgumentException().isThrownBy {
            inputRacingRoundContentCheck(fourthInput)
        }
    }
}
