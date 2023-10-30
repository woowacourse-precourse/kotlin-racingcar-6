package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNamesTest : NsTest() {
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
    fun `전진 전진`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
                },
                MOVING_FORWARD, MOVING_FORWARD
        )
    }

    // 5자 초과
    @Test
    fun `이름 5자 초과 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji") }
        }
    }

    @Test
    fun `이름 중복 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi") }
        }
    }

    @Test
    fun `이름 빈 문자열 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ") }
        }
    }

    @Test
    fun `일부 이름 빈 문자열 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",pobi") }
        }
    }

//    @Test
//    fun `쉼표로 나누어서 이름 저장`() {
//        assertSimpleTest {
//            run("pobi,woni")
//            print(getCarNames())
//            assertThat(getCarNames()).contains("pobi", "woni")
//        }
//    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
