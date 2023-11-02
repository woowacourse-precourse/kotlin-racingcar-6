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
    fun `자동차 전진`() {
        val car = Car("test")
        car.moveOrStay(MOVING_FORWARD)
        val expectedPosition = 1
        assertThat(expectedPosition).isEqualTo(car.getPosition())
    }

    @Test
    fun `자동차 정지`() {
        val car = Car("test")
        car.moveOrStay(STOP)
        val expectedPosition = 0
        assertThat(expectedPosition).isEqualTo(car.getPosition())
    }

    @Test
    fun `자동차 이름 및 위치 출력 - 위치가 0일 경우`() {
        val car = Car("test", 0)
        System.setOut(PrintStream(outputStreamCaptor))

        println(car)

        System.setOut(originalOut)
        val expectedOutPut = outputStreamCaptor.toString().trim()
        assertEquals(expectedOutPut, "test :")
    }

    @Test
    fun `자동차 이름 및 위치 출력 - 위치가 0보다 클 경우`() {
        val car = Car("test", 3)
        System.setOut(PrintStream(outputStreamCaptor))

        println(car)

        System.setOut(originalOut)
        val expectedOutPut = outputStreamCaptor.toString().trim()
        assertEquals(expectedOutPut, "test : ---")
    }

    @Test
    fun `자동차 우승 확인 테스트 - 위치가 최댓값과 다를 경우`() {
        val car = Car("test")
        val expected = car.isWinner(1)
        assertThat(expected).isFalse()
    }

    @Test
    fun `자동차 우승 확인 테스트 - 위치가 최댓값과 같을 경우`() {
        val car = Car("test", 3)
        val expected = car.isWinner(3)
        assertThat(expected).isTrue()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}