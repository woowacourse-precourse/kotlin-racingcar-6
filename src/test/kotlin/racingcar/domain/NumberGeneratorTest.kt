package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberGeneratorTest {
    @Test
    fun `난수가 0부터 9까지의 범위에 있다`() {
        val numberGenerator = NumberGenerator()
        for (i in 1..100) {
            val randomNumber = numberGenerator.createRandomNumber()
            assertTrue(randomNumber in 0..9)
        }
    }
}
