package racingcar.validaotr

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.validator.CarNameValidator

class CarNameValidatorTest {
    private val validator = CarNameValidator()

    @Test
    fun `이름에 공백을 입력 시 예외 발생 테스트 1`() {
        val input = ""
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이름에 공백을 입력 시 예외 발생 테스트 2`() {
        val input = "abc,,def"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이름에 공백을 입력 시 예외 발생 테스트 3`() {
        val input = "abc,def,"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이름의 길이를 초과했을 때 예외 발생 테스트 1`() {
        val input = "abcdef"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이름의 길이를 초과했을 때 예외 발생 테스트 2`() {
        val input = "abc,defghi"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이름의 길이를 초과했을 때 예외 발생 테스트 3`() {
        val input = "      ab"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이름이 중복되었을 때 예외 발생 테스트 1`() {
        val input = "abc,abc,def"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이름이 중복되었을 때 예외 발생 테스트 2`() {
        val input = "   a,   a"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }
}