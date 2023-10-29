package racingcar.model

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable

class CarTest {

    lateinit var car: Car

    @Test
    fun `Car 이름이 empty 이면 예외를 던진다`() {
        car = Car("")
        assertThrows<IllegalArgumentException>(
            "올바른 이름을 입력해주세요"
        ) {
            car.validateCar()
        }
    }

    @Test
    fun `Car 이름이 공백으로만 이루어졌다면 예외를 던진다`() {
        car = Car(" ")
        assertThrows<IllegalArgumentException>(
            "올바른 이름을 입력해주세요"
        ) {
            car.validateCar()
        }
    }

    @Test
    fun `Car 이름이 개행으로만 이루어졌다면 예외를 던진다`() {
        car = Car("\n")
        assertThrows<IllegalArgumentException>(
            "올바른 이름을 입력해주세요"
        ) {
            car.validateCar()
        }
    }

    @Test
    fun `Car 이름이 5자 초과라면 예외를 던진다`() {
        car = Car("abcdef")
        assertThrows<IllegalArgumentException>(
            "이름은 5자 이하까지 입력 가능합니다."
        ) {
            car.validateCar()
        }
    }

    @Test
    fun `Car 이름이 5자 이하 notBlank 이면 정상 실행된다`() {
        car = Car("abcde")
        val executable = Executable { car.validateCar() }
        assertDoesNotThrow(executable)

    }
}