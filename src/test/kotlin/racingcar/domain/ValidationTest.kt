package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Validation.checkContainComma
import java.lang.IllegalArgumentException

class ValidationTest {

    @Test
    fun `쉼표 체크 메서드 테스트`() {
        val input = "가은 나은 다은"
        assertThrows<IllegalArgumentException> {
            checkContainComma(input)
        }
    }

}