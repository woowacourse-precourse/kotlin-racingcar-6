package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.controller.RacingcarController
import racingcar.model.GenerateRandomNumber
import org.junit.jupiter.api.Assertions.assertTrue
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import racingcar.model.MoveCar
import racingcar.model.Winner
import org.junit.jupiter.api.BeforeEach


class RacingcarGameTest {
    private val racingcarController = RacingcarController()
    private val winner = Winner()
    private lateinit var moveCar: MoveCar
    private lateinit var generateRandomNumber: GenerateRandomNumber

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

    @BeforeEach
    fun setUp() {
        generateRandomNumber = mock(GenerateRandomNumber::class.java)
        moveCar = MoveCar(generateRandomNumber)
    }

    @Test
    fun `무작위 값이 4이상 일 때 전진 검증`() {
        val carScore = mutableMapOf("test1" to 0, "test2" to 0, "test3" to 0)
        `when`(generateRandomNumber.generate()).thenReturn(5) // 무작위 숫자를 5로 설정

        moveCar.calculateScore(carScore)

        assertEquals(1, carScore["test1"])
        assertEquals(1, carScore["test2"])
        assertEquals(1, carScore["test3"])
    }

    @Test
    fun `무작위 값이 4미만 일 때 전진하지 않음을 검증`() {
        val carScore = mutableMapOf("test1" to 0, "test2" to 0, "test3" to 0)
        `when`(generateRandomNumber.generate()).thenReturn(2) // 무작위 숫자를 2로 설정

        moveCar.calculateScore(carScore)

        assertEquals(0, carScore["test1"])
        assertEquals(0, carScore["test2"])
        assertEquals(0, carScore["test3"])
    }
}