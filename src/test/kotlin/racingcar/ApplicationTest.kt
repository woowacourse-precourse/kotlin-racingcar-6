package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "pobi,,java", "pobi,java,"])
    fun `공백 이름에 대한 예외 처리`(name: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(name, "1") }
        }
    }

    @Test
    fun `중복 이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java,pobi", "1") }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["one", "0", " "])
    fun `시도 횟수에 대한 예외 처리`(tryNum: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", tryNum) }
        }
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
