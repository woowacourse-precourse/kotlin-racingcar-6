package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.toCarNameList

class ApplicationTest : NsTest() {
    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `문자열을 쉼표 기준으로 분리한다`() {
        // given
        val case = "pobi,woni,jun"

        // when
        val result = case.toCarNameList()

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `쉼표가 없는 문자열을 쉼표 기준으로 분리하는 경우 기존 문자열을 반환`() {
        // given
        val case = "pobi"

        // when
        val result = case.toCarNameList()

        // then
        assertThat(result).isEqualTo("pobi")
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
