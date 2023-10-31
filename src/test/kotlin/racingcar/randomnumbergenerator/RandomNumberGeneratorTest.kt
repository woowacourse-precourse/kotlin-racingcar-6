package racingcar.randomnumbergenerator

import org.junit.jupiter.api.BeforeEach

class RandomNumberGeneratorTest {

    private lateinit var randomNumberGenerator: RandomNumberGenerator

    @BeforeEach
    fun setUp() {
        randomNumberGenerator = RandomNumberGeneratorImpl()
    }
}