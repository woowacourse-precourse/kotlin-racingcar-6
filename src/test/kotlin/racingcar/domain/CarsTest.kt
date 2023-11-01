package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarsTest {

    private lateinit var cars: Cars
    private val carNames = listOf("가은", "나은", "다은")

    @BeforeEach
    fun setUp() {
        cars = Cars(DetermineMove())
        cars.createCar(carNames)
    }

    @Test
    fun `자동차 객체가 제대로 생성되었는지 확인`() {

        assertEquals(carNames.size, cars.carList.size)

        cars.carList.forEachIndexed { index, car ->
            assertEquals(car.name, carNames[index])
            assertEquals(car.advanceState, 0)
        }

    }

}