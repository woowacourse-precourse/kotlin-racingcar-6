package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RacingNumberGeneratorTest {
    private val racingNumberGenerator = RacingNumberGenerator()

    @Test
    fun `get 메서드 사용 시 0 부터 9 사이의 정수값을 반환`() {
        val result = 0..9

        assertThat(racingNumberGenerator.get()).isIn(result)
    }
}