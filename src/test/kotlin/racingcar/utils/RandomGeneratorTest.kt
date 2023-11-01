package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomGeneratorTest {
    @Test
    fun `0부터 9사이의 난수 생성 테스트`() {
        repeat(10000) {
            val result = RandomGenerator.generateRandomNumber()
            assertThat(result).isBetween(0, 9)
        }
    }
}