package racingcar.domain

import org.junit.jupiter.api.BeforeEach

class CarsTest {

    private lateinit var cars: Cars
    private val carNames = listOf("가은", "나은", "다은")

    @BeforeEach
    fun setUp() {
        cars = Cars(DetermineMove())
        cars.createCar(carNames)
    }

}