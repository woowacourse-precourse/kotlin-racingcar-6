package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.constant.Constants.MIN_FORWARD_THRESHOLD

class CarStatusUpdaterTest {
    private val carStatusUpdater = CarStatusUpdater()

    @Test
    fun `moveCarForward는 난수가 경계값 이상일 때 자동차를 전진`() {
        val carStatus = mutableMapOf("CAR" to "")
        carStatusUpdater.moveCarForward(carStatus, "CAR", MIN_FORWARD_THRESHOLD)

        assertEquals("-", carStatus["CAR"])
    }

    @Test
    fun `moveCarForward는 난수가 경계값 미만일 때 자동차를 정지`() {
        val carStatus = mutableMapOf("CAR" to "")
        carStatusUpdater.moveCarForward(carStatus, "CAR", MIN_FORWARD_THRESHOLD - 1)

        assertEquals("", carStatus["CAR"])
    }
}
