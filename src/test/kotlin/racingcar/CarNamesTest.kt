package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNamesTest : NsTest() {
    @Test
    fun `우승자 정상 출력 (전진, 정지)`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
                },
                MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `공동 우승자 (전진 전진)`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
                },
                MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `아무도 전진하지 않은 경우`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni")
                },
                STOP, STOP
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

    @Test
    fun `Split 메서드로 자동차 이름 구분`() {
        assertSimpleTest {
            val names = getCarNames("pobi,woni")

            assertThat(names).contains("pobi","woni")
        }
    }

    @Test
    fun `Split 메서드로 자동차 이름 구분 후 앞뒤 공백 제거`() {
        assertSimpleTest {
            val names = getCarNames("pobi, woni")

            assertThat(names).contains("pobi","woni")
        }
    }

    @Test
    fun `Split 메서드 사용시 구분자가 포함되지 않은 경우 값 그대로 반환`() {
        assertSimpleTest {
            val names = getCarNames("pobi")

            assertThat(names).contains("pobi")
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
