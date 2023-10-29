package racingcar

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.service.RacingService
import racingcar.service.RacingService.Companion.MINIMUM_NUMBER_TO_WIN

class RacingTest {

    @Test
    fun `isGoForward 함수가 MINIMUM_NUMBER_TO_WIN 이상의 숫자를 반환하면 true를 반환해야 함`() {
        val randomNumber = MINIMUM_NUMBER_TO_WIN + 1

        val result = RacingService().isGoForward(randomNumber)

        assertTrue(result)
    }

    @Test
    fun `isGoForward 함수가 MINIMUM_NUMBER_TO_WIN 미만의 숫자를 반환하면 false를 반환해야 함`() {
        val randomNumber = MINIMUM_NUMBER_TO_WIN - 1

        val result = RacingService().isGoForward(randomNumber)
        
        assertFalse(result)
    }
}