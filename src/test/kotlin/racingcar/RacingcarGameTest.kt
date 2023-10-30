package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.controller.RacingcarController
import racingcar.model.GenerateRandomNumber
import org.junit.jupiter.api.Assertions.assertTrue


class RacingcarGameTest {
    private val racingcarController = RacingcarController()
    private val generateRandomNumber = GenerateRandomNumber()
    @Test
    fun `입력한 자동차 이름이 쉼표 기준으로 구분 검증`() {
        val input = "test1,test2,test3"
        val result = racingcarController.splitRacingcarName(input)
        Assertions.assertThat(result).contains("test3", "test2", "test1")
        Assertions.assertThat(result).containsExactly("test1", "test2", "test3")
    }

    @Test
    fun `0 ~ 9 사이 무작위 값만 생성 검증`() {
        val result = generateRandomNumber.generate()
        assertTrue(result in 0..9)
    }
}