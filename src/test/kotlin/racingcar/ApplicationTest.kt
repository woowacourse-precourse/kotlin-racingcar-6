package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import org.assertj.core.api.Assertions.assertThat

class ApplicationTest : NsTest() {
    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            }, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }
    @Test
    fun `askCarName 메서드 사용시 이름이 5자 이상일 때 예외 발생`() {
        //given
        val input = "pobi,java,joontae,car"

        //then
        assertThrows<IllegalArgumentException>("String index out of range: 5") {
            askCarName(
                input
            )
        }
    }
    @Test
    fun `askNumber 메서드 문자 입력 시 예외 발생`() {
        //given
        val input = "1"
        val result = 1

        //then
        assertThat(askNumber(input)).isEqualTo(result)
    }
    @Test
    fun `decideWinner 우승자가 아닐 때 false 출력`() {
        //given
        val testCar = Car("test")
        val isFirst = true
        //when
        run("pobi,woni,joon", "1")

        //then
        assertThat(decideWinner(testCar,isFirst)).isEqualTo(true)
    }
    @Test
    fun `printWinner 단독 우승시`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,hodol", "2")
                assertThat(output()).contains("pobi : --", "woni : ","hodol : ", "최종 우승자 : pobi")
            }, MOVING_FORWARD, STOP, STOP,MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `printWinner 공동 우승시`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,joon", "1")
                assertThat(output()).contains(
                    "pobi : -", "woni : -", "joon : -", "최종 우승자 : pobi, woni, joon"
                )
            }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
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
