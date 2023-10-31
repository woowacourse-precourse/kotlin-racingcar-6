package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `주어진 횟수만큼 전진했는지 테스트`() {
        val car = Car("TestCar")
        val forwardCount = 5
        repeat(forwardCount) {
            car.moveForward()
        }
        assertEquals(forwardCount, car.position)
    }

    @Test
    fun `문자열 변환 테스트 - 전진하지 않았을 때`() {
        val carName = "TestCar"
        val car = Car(carName)
        assertEquals("$carName : ", car.toString())
    }

    @Test
    fun `문자열 변환 테스트 - 전진했을 때`() {
        val carName = "TestCar"
        val car = Car(carName)

        val forwardCount = 5
        repeat(forwardCount) {
            car.moveForward()
        }

        val expected = "$carName : ${"-".repeat(forwardCount)}"
        assertEquals(expected, car.toString())
    }
}