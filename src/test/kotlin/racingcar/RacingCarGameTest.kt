package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.controller.RacingCarGameImpl
import racingcar.model.RacingCar

class RacingCarGameTest {
    private lateinit var racingCarGameImpl: RacingCarGameImpl

    @BeforeEach
    fun setUp() {
        racingCarGameImpl = RacingCarGameImpl()
    }

    @Test
    fun `createRacingCars - Given 주어진 유효한 차량 이름, when 차량 생성 함수 호출, then 같은 개수의 차량을 생성해야 함`() {
        // Given
        val racingCarNames = listOf("Car1", "Car2", "Car3")

        // When
        val racingCars = racingCarGameImpl.createRacingCars(racingCarNames)

        // Then
        assertEquals(racingCarNames.size, racingCars.size)
        assertTrue(racingCars.all { true })
    }

    @Test
    fun `moveRacingCars - Given 주어진 차량 목록, when 차량 이동 함수 호출, then 같은 개수의 차량 목록을 반환해야 함`() {
        // Given
        val racingCars = listOf(RacingCar("Car1"), RacingCar("Car2"), RacingCar("Car3"))

        // When
        val movedRacingCars = racingCarGameImpl.moveRacingCars(racingCars)

        // Then
        assertTrue(movedRacingCars.size == racingCars.size)
    }

    @Test
    fun `getWinners - Given 주어진 차량 목록, when 일부 차량이 전진한 경우, then 승리한 차량(들)의 이름을 반환해야 함`() {
        // Given
        var racingCars = listOf(RacingCar("Car1"), RacingCar("Car2"), RacingCar("Car3"))
        racingCars = racingCars.map { racingCar ->
            if (racingCar.name == "Car1") racingCar.move()
            else racingCar
        }

        // When
        val winners = racingCarGameImpl.getWinners(racingCars)

        // Then
        assertEquals("Car1", winners)
    }
}