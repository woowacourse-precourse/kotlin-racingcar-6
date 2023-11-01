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

    @Test
    fun `이름이 범위 밖인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",javaji", "1") }
        }
    }

    @Test
    fun `,외 다른 것으로 구분 시 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("ppb.ads", "1") }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["@", "한", "A", "", " "])
    fun `시도할 횟수가 숫자가 아닌 경우`(testInput: String) {
        assertThrows<IllegalArgumentException>("숫자를 입력해주세요") {
            require(testInput.toIntOrNull() != null)
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