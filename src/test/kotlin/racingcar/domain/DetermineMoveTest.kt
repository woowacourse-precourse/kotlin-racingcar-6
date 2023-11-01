package racingcar.domain

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DetermineMoveTest {

    @Test
    fun `isMove 메서드의 true 및 false 반환 테스트`() {
        val determineMove = DetermineMove()
        assertRandomNumberInRangeTest(
            {
                assertThat(determineMove.isMove()).isTrue
                assertThat(determineMove.isMove()).isFalse
            },
            6,  2,
        )
    }
}