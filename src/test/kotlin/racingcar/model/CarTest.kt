package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable

class CarTest {

    lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car(name = "car")
    }

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

    @Test
    fun `생성한 랜덤 수가 4 이상이면 앞으로 나아간다`() {
        car = Car(name = "car", position = 0)
        car.moveForward(NumberGeneratorTest(4))
        Assertions.assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `생성한 랜덤 수가 3 이하이면 앞으로 나아가지 않는다`() {
        car = Car(name = "car", position = 0)
        car.moveForward(NumberGeneratorTest(3))
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