package racingcar.view

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

class InputViewTest {
    private val inputView = InputView()


    @Test
    fun `이름 입력에 쉼표가 없는 경우`() {
        val input = "pobi.james.stone"
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException>("입력값에 쉼표가 포함되지 않았습니다.") {
                inputView.validateNotFindComma(input)
            }
        }
    }

    @Test
    fun `이름 길이가 5가 넘는 입력이 있는 경우`() {
        val input = "pobi,james,woteco"
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException>("5글자가 넘는 자동차 이름이 있습니다.") {
                inputView.splitInputNames(input)
            }
        }
    }

    @Test
    fun `중복된 이름이 있는 경우`() {
        val input = "pobi,james,james"
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException>("중복된 자동차 이름이 있습니다.") {
                inputView.splitInputNames(input)
            }
        }
    }

    @Test
    fun `횟수에 문자가 들어올 경우`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                inputView.validateInputTryCount("go")
            }
        }
    }

    @Test
    fun `횟수에 0이 입력될 경우`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                inputView.validateInputTryCount("0")
            }
        }
    }

    @Test
    fun `자동차 입력을 쉼표로 나누기`() {
        assertThat(
            inputView.splitInputNames("pobi,woni,stone")
        ).containsExactly("pobi", "woni", "stone")
    }

}