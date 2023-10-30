package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.controller.RacingcarController

class RacingcarGameTest {
    private val racingcarController = RacingcarController()
    @Test
    fun `입력한 자동차 이름이 쉼표 기준으로 구분 검증`() {
        val input = "test1,test2,test3"
        val result = racingcarController.splitRacingcarName(input)
        Assertions.assertThat(result).contains("test3", "test2", "test1")
        Assertions.assertThat(result).containsExactly("test1", "test2", "test3")
    }
}