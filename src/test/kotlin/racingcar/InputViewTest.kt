package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.view.InputView

class InputViewTest : NsTest() {
    private val inputView = InputView()

    @ParameterizedTest
    @ValueSource(strings = ["asd,asdf,zxczxc", "asdcsad,asdf,zxc", "asdfasdasdf"])
    fun `이름 설정에 대한 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { inputView.checkRacingCarNameSize(input.split(",")) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["3.1", "0", "a"])
    fun `반복 입력값이 자연수인지 아닌지 대한 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { inputView.checkNumber(input) }
    }

    override fun runMain() {
        main()
    }
}