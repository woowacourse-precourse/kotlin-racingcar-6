package racingcar.validator

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class ValidatorTest {

    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = ValidatorImpl()
    }

    @ParameterizedTest
    @ValueSource(strings = ["람보르기니우르스", "제네시스쿠페", "SORENTO"])
    fun `자동차 이름이 5글자 이하가 아닐 때 예외를 던지는지`(carName: String) {
        assertThrows<IllegalArgumentException> { validator.nameLength(carName) }
    }
}
