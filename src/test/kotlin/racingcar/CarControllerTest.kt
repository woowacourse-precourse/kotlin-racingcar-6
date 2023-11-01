package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.controller.CarController
import racingcar.data.Car

class CarControllerTest {
    @Test
    fun `경주할 자동차를 생성한다`() {
        val carController = CarController()
        val inputCars = mutableListOf<Car>()
        val input = "pobi,woni,jun"
        input.split(",").forEach { name ->
            inputCars.add(Car(name = name))
        }

        carController.createCars(input)
        val cars = carController.getCars()

        assertThat(cars).isEqualTo(inputCars)
    }
}