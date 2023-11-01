package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
    fun `generate0to9() 범위 테스트`() {
        assertThat(generate0to9()).isLessThan(10).isGreaterThan(-1)
    }

    @Test
    fun `decideWinners() 결과 테스트`() {
        val list = listOf(
            Car("test1", 4),
            Car("test2", 3),
            Car("test3", 2),
            Car("test4", 1)
        )
        assertThat(decideWinners(list)).containsExactly("test1")
    }

    @Test
    fun `announceWinners() 결과 테스트`() {
        val list = listOf("test1", "test2", "test3")
        assertThat(announceWinners(list)).isEqualTo("최종 우승자 : test1, test2, test3")
    }

    @Test
    fun `isNamein5Letters() 테스트`() {
        val list = listOf("abcde", "abcedf")
        assertThat(isNamein5Letters(list)).isFalse()
    }

    @Test
    fun `getExecutionNum() null 테스트`() {
        assertThrows<IllegalArgumentException> {
            getExecutionNum(null)
        }
    }

    @Test
    fun `getExecutionNum() 이상값 테스트`() {
        assertThrows<IllegalArgumentException> {
            getExecutionNum(" ")
        }
    }

    @Test
    fun `getExecutionNum() 정상값 테스트`() {
        assertThat(getExecutionNum("3")).isEqualTo(3)
    }

    @Test
    fun `getInputList() 이상값 테스트`() {
        assertThrows<IllegalArgumentException> {
            getInputList(null)
        }
    }

    @Test
    fun `getInputList() 정상값 테스트`() {
        assertThat(getInputList("abced,aaaaa,bbbbb")).containsExactly("abced", "aaaaa", "bbbbb")
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
