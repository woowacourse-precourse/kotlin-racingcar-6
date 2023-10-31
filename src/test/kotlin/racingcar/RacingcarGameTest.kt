package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.controller.RacingcarController
import racingcar.model.GenerateRandomNumber
import org.junit.jupiter.api.Assertions.assertTrue
import racingcar.model.MoveCar
import racingcar.model.Winner


class RacingcarGameTest {
    private val racingcarController = RacingcarController()
    private val generateRandomNumber = GenerateRandomNumber()
    private val moveCar = MoveCar()
    private val winner = Winner()
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

    @Test
    fun `최종 우승자가 올바른지 검증`() {
        val input = mutableMapOf(
            "test1" to 3,
            "test2" to 2,
            "test3" to 4
        )
        val result = winner.calculateWinner(input)
        Assertions.assertThat(result).containsExactly("test3")
    }

    @Test
    fun `최종 우승자가 2명 이상일 때 검증`() {
        val input = mutableMapOf(
            "test1" to 4,
            "test2" to 2,
            "test3" to 4
        )
        val result = winner.calculateWinner(input)
        Assertions.assertThat(result).containsExactly("test1", "test3")
    }
}