package racingcar.view

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import java.lang.NullPointerException

class InputViewTest {
    private val inputView = InputView()

    @Test
    fun `경주에 참여하는 자동차 이름 목록 검증`() {
        val input = listOf("jun", "pobi", "dana")
        val result = inputView.validateNameLength(input)
        assertThat(result).isEqualTo(listOf("jun", "pobi", "dana"))
    }

    @Test
    fun `5자 초과의 이름 포함된 경우`(){
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException>("자동차 이름은 5자 이하만 가능합니다.") {
                inputView.validateNameLength(listOf("olivia", "dana", "pobi"))
            }
        }
    }

    @Test
    fun `자동차 이름 목록에 빈 값이 있는 경우`(){
        Assertions.assertSimpleTest {
            assertThrows<NullPointerException>("아무것도 입력하지 않았습니다.") {
                inputView.validateNameLength(listOf("", "A", "pobi"))
            }
        }
    }

    @Test
    fun `자동차 이름 목록에 공백이 포함되어 있는 경우`(){
        assertThrows<IllegalArgumentException>("공백이 포함되어 있습니다.") {
            inputView.validateNameContainsEmpty(listOf(" ", "pobi", "jon"))
        }
    }

    @Test
    fun `입력된 자동차 이름 목록 중에 중복된 이름이 있는 경우`(){
        val input = listOf("jon", "jon", "pobi", "dana")
        val result = inputView.validateNameContainsEmpty(input)
        assertThat(result).isEqualTo(listOf("jon", "pobi", "dana"))
    }

    @Test
    fun `시도 횟수 입력에 숫자가 입력된 경우`(){
        val input = "3"
        val result = inputView.validateInputTryNumber(input)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `입력된 시도 횟수에 문자가 포함된 경우`(){
        val input = "3d"
        assertThrows<IllegalArgumentException> { inputView.validateInputTryNumber(input) }
    }

    @Test
    fun `입력된 시도 횟수에 아무것도 입력하지 않은 경우`(){
        val input = ""
        assertThrows<NullPointerException> { inputView.validateInputTryNumber(input) }
    }

    @Test
    fun `시도 횟수를 0으로 입력한 경우`(){
        val input = "0"
        assertThrows<IllegalArgumentException>("0보다 큰 수를 입력 해야 합니다.") {
            inputView.validateInputTryNumber(input)
        }
    }

}