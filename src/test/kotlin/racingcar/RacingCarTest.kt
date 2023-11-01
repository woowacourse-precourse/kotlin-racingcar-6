package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarTest {
    @Test
    fun `쉼표를 구분자로 경주할 자동차 이름`() {
        val result = splitRacingCarName("pobi,woni,jun")
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `유효하지 않은 자동차 이름`() {
        assertThrows<IllegalArgumentException>("자동차 이름은 5자 이하만 가능합니다.") {
            invalidRacingCarNamesCheck(listOf("pobi", "woni", "junjunjunjunjun"))
        }
    }

    @Test
    fun `유효하지 않은 횟수 입력`() {
        assertThrows<IllegalArgumentException>("정수를 입력하세요.") {
            invalidTryCountCheck("abc".toIntOrNull())
        }
        assertThrows<IllegalArgumentException>("정수를 입력하세요.") {
            invalidTryCountCheck((Int.MAX_VALUE.toLong() + 1).toString().toIntOrNull())
        }
        assertThrows<IllegalArgumentException>("1 이상의 숫자를 입력하세요.") {
            invalidTryCountCheck("-2".toIntOrNull())
        }
    }

    @Test
    fun `자동차 생성`() {
        val racingCar = RacingCar("pobi")
        assertThat(racingCar.name).isEqualTo("pobi")
    }

    @Test
    fun `자동차 전진`() {
        val racingCar = RacingCar("pobi")
        racingCar.move()
        assertThat(racingCar.mileage).isBetween(0, 1)
    }

    @Test
    fun `자동차 주행거리 출력`() {
        val racingCar = RacingCar("pobi")
        racingCar.move()
        racingCar.move()
        assertThat(racingCar.nameAndMileage().split(" : ").first()).isEqualTo("pobi")
        assertThat(racingCar.nameAndMileage().split(" : ").last().length).isBetween(0, 2)
    }

    @Test
    fun `최종 우승자 출력`() {
        var racingCars = listOf(RacingCar("pobi"), RacingCar("woni"), RacingCar("jun"))
        racingCars[0].mileage = 1
        racingCars[1].mileage = 2
        racingCars[2].mileage = 3
        assertThat(finalWinner(racingCars)).isEqualTo("최종 우승자 : jun")
        racingCars = listOf(RacingCar("pobi"), RacingCar("woni"), RacingCar("jun"))
        racingCars[0].mileage = 1
        racingCars[1].mileage = 2
        racingCars[2].mileage = 2
        assertThat(finalWinner(racingCars)).isEqualTo("최종 우승자 : woni, jun")
    }
}