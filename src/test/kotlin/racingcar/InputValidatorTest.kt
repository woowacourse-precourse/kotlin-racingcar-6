package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.controller.InputValidator

class InputValidatorTest {

    @Test
    fun `쉼표(,)를 통해 자동차 이름을 구분`(){
        val input = "a,b,c"
        var result = InputValidator.validateCarNameString(input)
        assertThat(result).isEqualTo(true);
    }

    @Test
    fun `쉼표(,)가 맨 앞, 또는 맨 뒤에 있을 때 false 반환`() {
        val input = "a,b,안녕이다,"
        var result = InputValidator.validateCarNameString(input);
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `자동차 이름이 5자 이하이며 영어, 숫자로 이루어져 있을 경우 true 반환`(){
        val str = mutableListOf<String>("ab","abcd","abc4")
        var result = InputValidator.validateCarName(str)
        assertThat(result).isEqualTo(true);
    }
    @Test
    fun `자동차 이름이 5자 이상이거나 1글자 미만이며 영어, 숫자 외의 문자로 이루어져 있을 경우 false 반환`(){
        val str = mutableListOf<String>("a","abc","", "abc145")
        var result = InputValidator.validateCarName(str)
        assertThat(result).isEqualTo(false);
    }
}