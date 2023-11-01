package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Validation.checkContainComma
import racingcar.domain.Validation.checkNameLength
import racingcar.domain.Validation.checkSameName
import kotlin.IllegalArgumentException

class ValidationTest {

    @Test
    fun `쉼표 체크 메서드 테스트`() {
        val input = "가은 나은 다은"
        assertThrows<IllegalArgumentException> {
            checkContainComma(input)
        }
    }

    @Test
    fun `이름 길이 체크 메서드 테스트`() {
        val input = "가은,나은,여섯글자이름".split(",")
        assertThrows<IllegalArgumentException> {
            checkNameLength(input)
        }
    }

    @Test
    fun `중복된 이름 예외 처리 테스트`() {
        val input = "가은,가은,나은,다은".split(",")
        assertThrows<IllegalArgumentException> {
            checkSameName(input)
        }
    }

}