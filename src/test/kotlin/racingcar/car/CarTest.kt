package racingcar.car

import org.junit.jupiter.api.BeforeEach

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = CarImpl()
    }
}
