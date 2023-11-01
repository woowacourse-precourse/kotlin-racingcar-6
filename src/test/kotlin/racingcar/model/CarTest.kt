package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.config.ExceptionMessage.INVALID_CAR_NAME
import racingcar.config.ExceptionMessage.TOO_LONG_NAME

class CarTest {

    private lateinit var car: Car

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n"])
    fun `Car 이름 blank 입력 예외 테스트`(input: String) {
        car = Car(input)
        assertThrows<IllegalArgumentException>(INVALID_CAR_NAME) {
            car.validateCar()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "123456", "000000"])
    fun `Car 이름이 5자 초과라면 예외를 던진다`(input: String) {
        car = Car(input)
        assertThrows<IllegalArgumentException>(TOO_LONG_NAME) {
            car.validateCar()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcd", "1234", "0000"])
    fun `Car 이름이 5자 이하 notBlank 이면 정상 실행된다`(input: String) {
        car = Car(input)
        assertDoesNotThrow { car.validateCar() }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6])
    fun `생성한 랜덤 수가 4 이상이면 앞으로 나아간다`(randomNumber: Int) {
        car = Car(name = "car", position = 0)
        car.moveForward(NumberGeneratorTest(randomNumber))
        Assertions.assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `생성한 랜덤 수가 3 이하이면 앞으로 나아가지 않는다`(randomNumber: Int) {
        car = Car(name = "car", position = 0)
        car.moveForward(NumberGeneratorTest(randomNumber))
        Assertions.assertThat(car.position).isEqualTo(0)
    }

    /**
     * 테스트 용도의 클래스
     *
     * 리턴하는 RandomNumber 를 개발자가 입력하는 값으로 한다.
     */
    class NumberGeneratorTest(private val returnValue: Int) : NumberGenerator() {
        override fun generateRandomNumber(): Int {
            return returnValue
        }
    }
}