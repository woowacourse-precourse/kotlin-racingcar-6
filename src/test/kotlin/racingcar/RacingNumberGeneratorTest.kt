package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RacingNumberGeneratorTest {
    private val racingNumberGenerator = RacingNumberGenerator()

    @Test
    fun `get 메서드 사용 시 0 부터 9 사이의 정수값을 반환`() {
        val result = MIN_RACING_NUMBER..MAX_RACING_NUMBER

        assertThat(racingNumberGenerator.get()).isIn(result)
    }

    companion object {
        private const val MIN_RACING_NUMBER = 0
        private const val MAX_RACING_NUMBER = 9
    }
}