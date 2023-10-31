
package racingcar.randomnumbergenerator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {

    private lateinit var randomNumberGenerator: RandomNumberGenerator

    @BeforeEach
    fun setUp() {
        randomNumberGenerator = RandomNumberGeneratorImpl()
    }

    @Test
    fun `랜덤으로 생성한 숫자가 0~9사이 숫자를 반환`() {
        val result = randomNumberGenerator.generateRandomNumber()

        assertThat(result)
            .isGreaterThanOrEqualTo(MINIMUM_RANDOM_NUMBER)
            .isLessThanOrEqualTo(MAXIMUM_RANDOM_NUMBER)
    }

    companion object {
        private const val MINIMUM_RANDOM_NUMBER = 0
        private const val MAXIMUM_RANDOM_NUMBER = 9
    }
}