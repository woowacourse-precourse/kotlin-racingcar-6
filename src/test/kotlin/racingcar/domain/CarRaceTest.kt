package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class CarRaceTest {
    private lateinit var carRace: CarRace

    @BeforeEach
    fun sutUp() {
        carRace = CarRace()
    }

    @RepeatedTest(10000)
    fun `랜덤 숫자 생성기 0~9까지 잘나오는지`() {
        val number = carRace.generateNumber()

        assertTrue(number >= CarRaceConstants.RANDOM_NUMBER_MIN && number <= CarRaceConstants.RANDOM_NUMBER_MAX)
    }

    @Test
    fun `스타트 플래그 정상적으로 나오는지`() {
        val startComment = CarRaceConstants.EXECUTION_RESULT

        val result = carRace.startFlag()

        assertEquals(startComment, result)
    }
}