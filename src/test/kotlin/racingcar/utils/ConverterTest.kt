package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConverterTest {

    @Test
    fun `주어진 값을 콤마로 분리하여 리스트로 반환`() {
        val string = "pobi,woni,jun"
        val result = Converter.splitByCommaToStringList(string)
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `주어진 값을 콤마로 분리하여 리스트로 반환 - 콤마가 없을 경우`() {
        val string = "pobi"
        val result = Converter.splitByCommaToStringList(string)
        assertThat(result).containsExactly("pobi")
    }

    @Test
    fun `주어진 값을 문자열로 반환`() {
        val string = "25"
        val expected = 25
        assertThat(expected).isEqualTo(Converter.convertStringToInt(string))
    }
}