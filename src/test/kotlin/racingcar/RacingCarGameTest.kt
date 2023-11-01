package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingCarGameTest : NsTest() {

    @Test
    fun `우승자가 몇 명인지에 따라 출력값이 달라진다`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                Assertions.assertThat(output()).contains("최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,yubi", "1")
                Assertions.assertThat(output()).contains("최종 우승자 : pobi, yubi")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}