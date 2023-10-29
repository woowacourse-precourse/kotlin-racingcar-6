package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.Util

class InputTest {

    @Test
    fun `split 메서드로 주어진 값을 구분`() {
        val input = "1,2"
        val result = Util.splitCarName(input)
        Assertions.assertThat(result).contains("2", "1")
        Assertions.assertThat(result).containsExactly("1", "2")
    }

    @Test
    fun `split 메서드 사용시 구분자가 포함되지 않은 경우 값을 그대로 반환`() {
        val input = "1"
        val result = Util.splitCarName(input)
        Assertions.assertThat(result).contains("1")
    }

    @Test
    fun `자동차의 이름이 5글자를 넘게 되면 예외 발생`() {
        val input = "abc123"
        assertThrows<IllegalArgumentException>("글자수가 5자 보다 깁니다.") {
            Util.checkCarName(input)
        }
    }

    @Test
    fun `toInt 메서드로 String을 Int타입으로 변경`(){
        val input = "1"
        val result = Util.stringToInt(input)
        Assertions.assertThat(result).isEqualTo(1)
    }

    @Test
    fun `toInt 메서드로 String이 Int타입으로 변경되지 않을때 예외 발생`(){
        val input = "one"
        val inputToInt = Util.stringToInt(input)
        assertThrows<IllegalArgumentException>("숫자형태의 String이 아닙니다.") {
            Util.checkInt(inputToInt)
        }
    }


}