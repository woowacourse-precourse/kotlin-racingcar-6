package racingcar.domain

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
        car.moveOrStay(MOVING_FORWARD)
        val expected = 1
        assertThat(expected).isEqualTo(car.getPosition())
    }

    @Test
    fun `자동차 전진 혹은 정지 테스트 2`() {
        val car = Car("test")
        car.moveOrStay(STOP)
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
        car.moveOrStay(MOVING_FORWARD)
        System.setOut(PrintStream(outputStreamCaptor))

        println(car)

        System.setOut(originalOut)
        val consoleOutput = outputStreamCaptor.toString().trim()
        val expected = "test : -"
        assertEquals(expected, consoleOutput)
    }

    @Test
    fun `자동차 우승 확인 테스트 1`() {
        val car = Car("test")
        car.moveOrStay(STOP)
        val expected = car.isWinner(1)
        assertThat(expected).isFalse()
    }

    @Test
    fun `자동차 우승 확인 테스트 2`() {
        val car = Car("test")
        car.moveOrStay(MOVING_FORWARD)
        val expected = car.isWinner(1)
        assertThat(expected).isTrue()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}