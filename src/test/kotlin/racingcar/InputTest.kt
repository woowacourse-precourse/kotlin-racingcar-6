package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest {
    @Test
    fun `이름 입력 후 쉼표(,)로 이름이 잘 나누어졌는지 확인`() {
        val input = "pobi,woni,jun"
        val name = input.split(",")
        assertThat(name).containsExactly("pobi", "woni", "jun")
    }
    @Test
    fun `이름이 하나만 입력되었을 경우 그대로 반환하는지 확인`() {
        val input = "pobi"
        val name = input.split(",")
        assertThat(name).contains("pobi")
    }

    @Test
    fun `실행 횟수 입력이 그대로 반환되는지 확인`() {
        val count = "10"
        assertThat(count).isEqualTo("10")
    }

}