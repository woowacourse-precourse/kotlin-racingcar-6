package racingcar.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow
import race.CarController
import race.CarModel
import race.PrintResult

class CarControllerTest {
    val printResult = PrintResult()
    val carModel = CarModel()
    val carController = CarController(carModel, printResult)

    @Test
    fun testValidateCarInput() {
        assertDoesNotThrow { carController.validateCarInput("Car1,Car2,Car3") }
        assertThrows<IllegalArgumentException> {
            carController.validateCarInput(",,Car2,Car3")
        }
        assertThrows<IllegalArgumentException> {
            carController.validateCarInput(",Car2,Car3")
        }
        assertThrows<IllegalArgumentException> {
            carController.validateCarInput("Car1,Car2,Car3,")
        }
        assertDoesNotThrow {
            carController.validateCarInput("Car1,Car2,Car3,Car4,Car5,Car6")
        }
    }

    @Test
    fun testCheckRepeatCar() {
        val carsWithDuplicates = listOf("Car1", "Car2", "Car1", "Car3", "Car2")
        val carsWithoutDuplicates = listOf("Car1", "Car2", "Car3", "Car4")

        assertThat(carController.checkRepeatCar(carsWithDuplicates)).isEqualTo(true)
        assertThat(carController.checkRepeatCar(carsWithoutDuplicates)).isEqualTo(false)
    }

    @Test
    fun testProcessCarInput() {
        assertDoesNotThrow { carController.processCarInput("Car1,Car2,Car3") }
        assertThrows<IllegalArgumentException> {
            carController.processCarInput("Car1, ,Car3")
        }
        assertThrows<IllegalArgumentException> {
            carController.processCarInput("Car1234,Car2,Car3")
        }
        assertThrows<IllegalArgumentException> {
            carController.processCarInput("Car1,Car2,Car1")
        }
        assertDoesNotThrow {
            carController.processCarInput("Car1,Car2,Car3,Car4,Car5,Car6")
        }
    }

    @Test
    fun testCheckMoveNum() {
        assertThat(carController.checkMoveNum("5")).isEqualTo(5)
        assertThrows<IllegalArgumentException> {
            carController.checkMoveNum("")
        }
        assertThrows<IllegalArgumentException> {
            carController.checkMoveNum("abc")
        }
    }
}
