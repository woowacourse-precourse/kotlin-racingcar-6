package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class myGameTest{

    @Test
    fun `우승자 다수 일때 쉼표로 구분하여 출력`()
    {
        val input = "pobi,woni,jun"
        val listOfCar = createListOfCar(input)
        listOfCar[0].position = 1
        listOfCar[2].position = 1
        val result = getWinners(listOfCar)
        assertThat(result).isEqualTo("pobi, jun")
    }

    @Test
    fun `현재 위치 출력`()
    {
        val name = "jun"
        val car = Car(name)
        car.position = 3
        assertThat(car.toString()).isEqualTo("$name : ---")
    }
}