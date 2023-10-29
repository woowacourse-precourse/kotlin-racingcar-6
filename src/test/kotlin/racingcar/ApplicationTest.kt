package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*
import racingcar.model.Move
import racingcar.util.GameMessage
import racingcar.util.RandomGenerator

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
    fun `횟수가 숫자가 아닐 경우 예외 처리`(){
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {runException("pobi,rion","a")  }
            assertEquals(exception.message,GameMessage.GAME_INPUT_ATTEMPT_ERROR_MESSAGE)
        }
    }
    @Test
    fun `생성되는 난수 검사`(){
        val minValue = 0
        val maxValue = 9
        val randomNumber = RandomGenerator.makeRandomNumber()
        assertTrue(randomNumber in minValue.. maxValue)
    }
    @Test
    fun `난수가 0~3일때 자동차 이동 결과`(){
        val testMove = Move(0)
        val beforePosition = testMove.position
        testMove.checkMove(Randoms.pickNumberInRange(0,3))
        val afterPosition = testMove.position
        assertEquals(beforePosition, afterPosition)
    }
    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
