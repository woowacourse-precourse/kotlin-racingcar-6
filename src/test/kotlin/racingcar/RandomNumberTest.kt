package racingcar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.model.RandomNumber
import racingcar.util.END_RANDOM_RANGE
import racingcar.util.START_RANDOM_RANGE

class RandomNumberTest {
    @Test
    fun `랜덤숫자_범위_테스트`() {
        val randomNumberGenerator = RandomNumber()
        val randomNumber = randomNumberGenerator.generateRandomNumber()

        assertTrue(randomNumber >= START_RANDOM_RANGE)
        assertTrue(randomNumber <= END_RANDOM_RANGE)
    }
}