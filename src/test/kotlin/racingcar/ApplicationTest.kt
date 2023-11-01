package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
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
    fun `우승자가 여러 명일 경우 출력`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni,vonvo", "1")
                    assertThat(output()).contains("pobi : -", "woni : ", "vonvo : -", "최종 우승자 : pobi,vonvo")
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `RacingCar 랜덤값 잘 생성하는지 확인 - 전진 시`() {
        val testCar = RacingCar("vonvo")
        assertRandomNumberInRangeTest(

                {
                    testCar.getRandomNum()
                    testCar.updateMoveCnt()
                    val result = testCar.getMoveCnt()
                    val answer = 1
                    assertThat(result).isEqualTo(answer)
                },
                5
        )
    }

    @Test
    fun `RacingCar 랜덤값 잘 생성하는지 확인 - 멈춤 시`() {
        val testCar = RacingCar("vonvo")
        assertRandomNumberInRangeTest(

                {
                    testCar.getRandomNum()
                    testCar.updateMoveCnt()
                    val result = testCar.getMoveCnt()
                    val answer = 0
                    assertThat(result).isEqualTo(answer)
                },
                3
        )
    }

    @Test
    fun `RacingCar printResult() 잘 동작하는지 확인`() {
        val testCar = RacingCar("vonvo")
        assertRandomNumberInRangeTest(

                {
                    testCar.getRandomNum()
                    testCar.updateMoveCnt()
                    testCar.getRandomNum()
                    testCar.updateMoveCnt()
                    val result = testCar.getMoveCnt()
                    val answer = 2
                    testCar.printResult()
                    assertThat(result).isEqualTo(answer)
                    assertThat(output()).contains("vonvo : --")
                },
                4, 5
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
