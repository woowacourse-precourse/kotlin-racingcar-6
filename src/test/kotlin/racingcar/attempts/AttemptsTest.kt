package racingcar.attempts

import org.junit.jupiter.api.BeforeEach

class AttemptsTest {

    private lateinit var attempts: Attempts

    @BeforeEach
    fun setUp() {
        attempts = AttemptsImpl()
    }
}
