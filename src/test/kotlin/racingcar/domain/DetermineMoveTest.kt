package racingcar.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DetermineMoveTest {

    @Test
    fun `isMove �޼����� true �� false ��ȯ �׽�Ʈ`() {
        val determineMove = DetermineMove()
        assertRandomNumberInRangeTest(
            {
                assertThat(determineMove.isMove()).isTrue
                assertThat(determineMove.isMove()).isFalse
            },
            6, 2,
        )
    }
}