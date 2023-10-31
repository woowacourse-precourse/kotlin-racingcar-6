/*
package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest  {
    */
/*@Test
    fun `이름에 대한 예외 처리(공백 포함)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi ,java", "1") }
        }
    }

    @Test
    fun `이름에 대한 예외 처리(특수문자 포함)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("hogu,kim**", "1") }
        }
    }

    @Test
    fun `이름에 대한 예외 처리(5자 초과 이름)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `이동 횟수에 대한 예외처리(문자 입력)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi ,java", "One") }
        }
    }

    @Test
    fun `이동 횟수에 대한 예외처리(음수 입력)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi ,java", "-1") }
        }
    }

    @Test
    fun `이동 횟수에 대한 예외처리(int 범위 초과 입력)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi ,java", "1000001") }
        }
    }

    @Test
    fun `실행 결과 출력 확인`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("실행 결과")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `출력 확인(자동차 이름과 결과 출력)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `출력 확인(최종 우승자 문장 출력)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("최종 우승자")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `출력 확인(단독 우승의 경우)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }


    @Test
    fun `출력 확인(공동 우승의 경우)`() {
        val result = Race().testRun()
        assertThat(result).isEqualTo("최종 우승자 : pobi, woni")
    }*//*


*/
/*
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
 *//*

*/
/*
    public override fun runMain() {
        main()
    }

 *//*


    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
*/
