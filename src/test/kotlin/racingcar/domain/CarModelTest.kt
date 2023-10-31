package racingcar.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import race.CarModel

class CarModelTest {
    val carModel = CarModel()

    @Test
    fun testAddCar() {
        carModel.addCar("Car1")
        carModel.addCar("Car2")

        val garage = carModel.garage
        assertThat(garage).containsKeys("Car1", "Car2")
        assertThat(garage["Car1"]).isEqualTo(0)
        assertThat(garage["Car2"]).isEqualTo(0)
    }

    @Test
    fun testMoveCars() {
        val moveNum = 5
        val initialGarageSize = carModel.garage.size
        carModel.moveCars(moveNum)
        val finalGarageSize = carModel.garage.size
        assertThat(finalGarageSize).isEqualTo(initialGarageSize)
    }

    @Test
    fun testGetWinners() {
        carModel.addCar("Car1")
        carModel.addCar("Car2")
        carModel.addCar("Car3")
        carModel.garage["Car1"] = 3
        carModel.garage["Car2"] = 5
        carModel.garage["Car3"] = 3
        val winners = carModel.getWinners()
        assertThat(winners).contains("Car2")
        assertThat(winners).doesNotContain("Car1")
        assertThat(winners).doesNotContain("Car3")
    }
}