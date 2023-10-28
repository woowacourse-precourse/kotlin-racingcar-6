package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.common.ExceptionConst

class MyApplicationTest {
    @Test
    fun `경주할 자동차 이름은 중복이 불가`() {
        val input = "hanmo, hanmo".split(",").map { it.trim() }
        assertThrows<IllegalArgumentException>(ExceptionConst.EXCEPTION_CAR_NAME_DUPLICATED) {
            validateCarNameDistinct(input)
        }
    }

    @Test
    fun `경주할 자동차 이름은 1글자 이상`() {
        val input = "".split(",").map { it.trim() }
        assertThrows<IllegalArgumentException>(ExceptionConst.EXCEPTION_CAR_NAME_LENGTH_INVALIDATE) {
            validateCarNameLength(input)
        }
    }

    @Test
    fun `경주할 자동차 이름은 5글자 이하`() {
        val input = "hanmohello".split(",").map { it.trim() }
        assertThrows<IllegalArgumentException>(ExceptionConst.EXCEPTION_CAR_NAME_LENGTH_INVALIDATE) {
            validateCarNameLength(input)
        }
    }
}
