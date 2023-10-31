package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarTest {
    @Test
    fun `쉼표를 구분자로 경주할 자동차 이름 체크`() {
        val result = splitRacingCarName("pobi,woni,jun")
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `자동차 이름을 잘 입력 했는지 체크`() {
        assertThrows<IllegalArgumentException>("자동차 이름은 5자 이하만 가능합니다.") {
            invalidRacingCarsCheck(listOf("pobi", "woni", "junjunjunjunjun"))
        }
    }
}