package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringListSplitterTest {

    @Test
    fun `주어진 값을 콤마로 분리하여 리스트로 반환`() {
        val string = "pobi,woni,jun"
        val result = StringListSplitter.splitByCommaToStringList(string)
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `주어진 값을 콤마로 분리하여 리스트로 반환 - 콤마가 없을 경우`() {
        val string = "pobi"
        val result = StringListSplitter.splitByCommaToStringList(string)
        assertThat(result).containsExactly("pobi")
    }
}