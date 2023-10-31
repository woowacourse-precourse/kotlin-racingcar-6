package racingcar.validator

import org.junit.jupiter.api.BeforeEach

class ValidatorTest {

    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = ValidatorImpl()
    }
}
