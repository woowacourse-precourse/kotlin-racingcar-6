package racingcar.Car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car
import racingcar.model.Cars

class Cars {

    @Test
    fun `중복된 자동차 이름이 존재하면 Cars 객채 생성 시 예외가 발생한다`() {
        val duplicateCars = listOf(
            Car("koo"),
            Car("min"),
            Car("min")
        )

        assertThrows<IllegalArgumentException> {
            Cars(duplicateCars)
        }
    }

    @Test
    fun `cars 리스트에서 position의 값이 제일 큰 Car 객체가 최종 우승자이다`() {
        val cars = Cars(
            listOf(
                Car("first"),
                Car("secon")
            )
        )

        val winner = cars.getWinners()
        Assertions.assertEquals("first", winner[0].name.value)
    }

}