package racingcar.attempts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class AttemptsTest {

    private lateinit var attempts: Attempts

    @BeforeEach
    fun setUp() {
        attempts = AttemptsImpl()
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 10, 15])
    fun `시도 횟수가 저장되는지 확인`(attempt: Int) {
        attempts.setAttempt(attempt)
        val result = attempts.attempt

        assertThat(attempt).isEqualTo(result)
    }
}
