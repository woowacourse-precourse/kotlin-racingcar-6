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
            invalidRacingCarNamesCheck(listOf("pobi", "woni", "junjunjunjunjun"))
        }
    }

    @Test
    fun `횟수 입력 체크`() {
        assertThrows<IllegalArgumentException>("정수를 입력하세요.") {
            invalidTryCountCheck("abc".toIntOrNull())
        }
        assertThrows<IllegalArgumentException>("정수를 입력하세요.") {
            invalidTryCountCheck((Int.MAX_VALUE.toLong() + 1).toString().toIntOrNull())
        }
        assertThrows<IllegalArgumentException>("1 이상의 숫자를 입력하세요.") {
            invalidTryCountCheck("-2".toIntOrNull())
        }
    }
}