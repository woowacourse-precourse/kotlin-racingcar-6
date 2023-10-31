package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingCarTest {
    @Test
    fun `쉼표를 구분자로 경주할 자동차 이름 체크`() {
        val result = splitRacingCarName("pobi,woni,jun")
        Assertions.assertThat(result).containsExactly("pobi", "woni", "jun")
    }
}