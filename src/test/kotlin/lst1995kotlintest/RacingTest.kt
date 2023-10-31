package lst1995kotlintest

import car.Car
import car.CarFactory.makeCar
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import race.Racing

class RacingTest {
    private var carList = listOf<Car>()
    private var racing = Racing()
    private var car = listOf<Car>()
    private var singleRacing = Racing()

    @BeforeEach
    fun setUp() {
        carList = makeCar("유재석,하하,김종국,송지효,전소민")
        car = makeCar("유재석")
        singleRacing.start(car)
    }

    @Test
    fun `레이싱 출발 검사`() {
        assertThat("${racing.start(carList)}")
            .contains("유재석 : ")
            .contains("하하 : ")
            .contains("김종국 : ")
            .contains("송지효 : ")
            .contains("전소민 : ")
            .contains("\n")
    }

    @Test
    fun `우승자 출력 검사`() {
        assertThat("${singleRacing.findWinner(car)}").isEqualTo("최종 우승자 : 유재석")
    }
}
