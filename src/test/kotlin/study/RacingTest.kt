package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.Car

class RacingTest {
    @Test
    fun `test printWinner`(){
        val winnerList = listOf<String>("Tom", "Jessi")
        val result = winnerList.joinToString(", ")
        assertThat(result).isEqualTo("Tom, Jessi")
    }

    @Test
    fun `test findWinner`(){
        val carList = mutableListOf<Car>()
        carList.add(Car("Tom", 3))
        carList.add(Car("Jessi", 5))
        carList.sort()
        val maxForwards = carList[0].cntForwards
        val result = mutableListOf<String>()
        for (car in carList) {
            if (car.cntForwards < maxForwards) {
                break
            }
            result.add(car.name)
        }
        assertThat(result).isEqualTo(listOf("Jessi"))
    }


}