package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarTest {
    private val originalOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @Test
    fun `자동차 생성 테스트`() {
        val car = Car("test")
        val expectedName = car.getName()
        val expectedPosition = car.getPosition()

        assertThat(car).isNotNull
        assertThat(expectedName).isEqualTo("test")
        assertThat(expectedPosition).isEqualTo(0)
    }

    @Test
    fun `자동차 전진 혹은 정지 테스트 1`() {
        val car = Car("test")
        car.moveOrStay(7)
        val expected = 1
        assertThat(expected).isEqualTo(car.getPosition())
    }

    @Test
    fun `자동차 전진 혹은 정지 테스트 2`() {
        val car = Car("test")
        car.moveOrStay(3)
        val expected = 0
        assertThat(expected).isEqualTo(car.getPosition())
    }

    @Test
    fun `자동차 위치 출력 테스트 1`() {
        val car = Car("test")
        System.setOut(PrintStream(outputStreamCaptor))

        println(car)

        System.setOut(originalOut)
        val consoleOutput = outputStreamCaptor.toString().trim()
        val expected = "test :"
        assertEquals(expected, consoleOutput)
    }

    @Test
    fun `자동차 위치 출력 테스트 2`() {
        val car = Car("test")
        car.moveOrStay(7)
        System.setOut(PrintStream(outputStreamCaptor))

        println(car)

        System.setOut(originalOut)
        val consoleOutput = outputStreamCaptor.toString().trim()
        val expected = "test : -"
        assertEquals(expected, consoleOutput)
    }

    @Test
    fun `자동차 우승 확인 기능 테스트 1`() {
        val car = Car("test")
        car.moveOrStay(2)
        val expected = car.isWinnerCar(1)
        assertThat(expected).isFalse()
    }

    @Test
    fun `자동차 우승 확인 기능 테스트 2`() {
        val car = Car("test")
        car.moveOrStay(7)
        val expected = car.isWinnerCar(1)
        assertThat(expected).isTrue()
    }
}