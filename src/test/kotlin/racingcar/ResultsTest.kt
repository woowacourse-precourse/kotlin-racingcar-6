package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ResultsTest : NsTest() {
    @Test
    fun `우승자 정상 출력 (전진, 정지)`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
                },
                ResultsTest.MOVING_FORWARD, ResultsTest.STOP
        )
    }

    @Test
    fun `공동 우승자 (전진, 전진)`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
                },
                ResultsTest.MOVING_FORWARD, ResultsTest.MOVING_FORWARD
        )
    }

    @Test
    fun `공동 우승자 (정지, 정지)`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni")
                },
                ResultsTest.STOP, ResultsTest.STOP
        )
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
