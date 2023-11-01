package racingcar.Car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.CarName

class CarName {
    @Test
    fun `자동차 이름이 5자를 초과하면 CarName 객체 생성 시 예외가 발생한다`() {
        val name = "GoodCar"

        assertThrows<IllegalArgumentException> {
            CarName(name)
        }
    }

    @Test
    fun `자동차 이름에 공백만 있을 경우 CarName 객체 생성 시 예외가 발생한다`() {
        val name = ""

        assertThrows<IllegalArgumentException> {
            CarName(name)
        }
    }

    @Test
    fun `자동차 이름 양 끝에 공백이 있어도 5자 이하이면 CarName 객체 생성 시 예외가 발생하지 않는다`() {
        val name = "  Min "
        val minCar = CarName(name)
        Assertions.assertEquals("Min", minCar.value)
    }
}