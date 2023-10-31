package study.model

import org.junit.jupiter.api.*
import racingcar.model.RandomNumberGenerator

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RandomNumberGeneratorTest {
    private lateinit var randomNumberGenerator: RandomNumberGenerator

    @BeforeEach
    fun `setUp`() {
        randomNumberGenerator = RandomNumberGenerator()
    }

    @Test
    fun `숫자가 0에서 9사이 인지 테스트`() {
        val zeroToNine = (0..9)
        assertAll(
            "0에서 9사이에 포함 되지 않는 숫자가 있습니다.",
            {assert(zeroToNine.contains(randomNumberGenerator.generate()))},
            {assert(zeroToNine.contains(randomNumberGenerator.generate()))},
            {assert(zeroToNine.contains(randomNumberGenerator.generate()))}
        )

    }
}