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
    private var startList = listOf(10, 1, 1, 1, 1)

    @BeforeEach
    fun setUp() {
        carList = makeCar("유재석,하하,김종국,송지효,전소민")
        carList.forEachIndexed { index, car ->
            repeat(startList[index]) {
                car.start()
            }
        }
        racing.start(carList)
    }

    @Test
    fun `레이싱 라운드 결과 반환값 검사`() {
        assertThat("${racing.start(carList)}")
            .contains("유재석 : ")
            .contains("하하 : ")
            .contains("김종국 : ")
            .contains("송지효 : ")
            .contains("전소민 : ")
            .contains("-")
            .contains("\n")
    }

    @Test
    fun `우승자 검색 후 반환값 검사`() {
        assertThat("${racing.findWinner(carList)}").isEqualTo("최종 우승자 : 유재석")
    }
}
