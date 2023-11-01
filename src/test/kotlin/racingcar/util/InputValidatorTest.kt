package racingcar.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.data.CarState

class InputValidatorTest {


    @Test
    fun `빈 입력`() {
        val input = listOf<String>()
        val result = InputValidator.validateUserName(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.UserNameValidation.LEAST_ONE)
    }

    @Test
    fun `한명 입력 정상`() {
        val input = listOf("p")
        val result = InputValidator.validateUserName(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.UserNameValidation.VALID)
    }

    @Test
    fun `한명 입력 경계선`() {
        val input = listOf("qwert")
        val result = InputValidator.validateUserName(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.UserNameValidation.VALID)
    }

    @Test
    fun `한명 입력 초과`() {
        val input = listOf("qwerty")
        val result = InputValidator.validateUserName(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.UserNameValidation.OVER_LENGTH)
    }

    @Test
    fun `여러명 입력 정상`() {
        val input = listOf("qwey", "Pobi", "한글")
        val result = InputValidator.validateUserName(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.UserNameValidation.VALID)
    }

    @Test
    fun `여러명 입력 초과`() {
        val input = listOf("qwey", "Pobi", "한글이 너무길면 어쩌죠")
        val result = InputValidator.validateUserName(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.UserNameValidation.OVER_LENGTH)
    }

    @Test
    fun `음수 입력`() {
        val input = "-1000"
        val result = InputValidator.validateGameCount(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.GameCountValidation.OUT_RANGE)
    }

    @Test
    fun `올바른 입력`() {
        val input = "1000"
        val result = InputValidator.validateGameCount(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.GameCountValidation.VALID)
    }

    @Test
    fun `숫자 앞에 0 입력`() {
        val input = "001000"
        val result = InputValidator.validateGameCount(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.GameCountValidation.VALID)
    }

    @Test
    fun `오버플로우 입력`() {
        val input = "99999999999999999999"
        val result = InputValidator.validateGameCount(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.GameCountValidation.NOT_INTEGER)
    }

    @Test
    fun `언더플로우 입력`() {
        val input = "-99999999999999999999"
        val result = InputValidator.validateGameCount(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.GameCountValidation.NOT_INTEGER)
    }

    @Test
    fun `문자 입력`() {
        val input = "abc"
        val result = InputValidator.validateGameCount(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.GameCountValidation.NOT_INTEGER)
    }

    @Test
    fun `아스키 코드`() {
        val input = "0x37"
        val result = InputValidator.validateGameCount(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.GameCountValidation.NOT_INTEGER)
    }

    @Test
    fun `음수 경계값 입력`() {
        val input = "-2147483648"
        val result = InputValidator.validateGameCount(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.GameCountValidation.OUT_RANGE)
    }

    @Test
    fun `양수 경계값 입력`() {
        val input = "2147483647"
        val result = InputValidator.validateGameCount(input)
        Assertions.assertThat(result).isEqualTo(InputValidator.GameCountValidation.VALID)
    }
}