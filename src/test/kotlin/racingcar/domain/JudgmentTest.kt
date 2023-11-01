package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.constant.Constants.MIN_FORWARD_THRESHOLD

class JudgmentTest {
    @Test
    fun `난수가 경계값 이상일 때 전진 가능`() {
        val judgment = Judgment()
        assertTrue(judgment.canMoveForward(MIN_FORWARD_THRESHOLD))
        assertTrue(judgment.canMoveForward(MIN_FORWARD_THRESHOLD + 1))
    }

    @Test
    fun `난수가 경계값 미만일 때 전진 불가능`() {
        val judgment = Judgment()
        assertFalse(judgment.canMoveForward(MIN_FORWARD_THRESHOLD - 1))
    }
}
