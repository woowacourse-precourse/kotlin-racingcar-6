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
    fun `자동차 위치 반환`() {
        val CarNames = listOf("car1", "car2")
        val game = RacingCarGame(CarNames)
        val positions = game.run(1)
        assertThat(positions.keys).containsAll(CarNames)
    }
    //함수나 클래스에 파라미터가 없으면 테스트코드를 못돌려보는건가
    //다른 사람들 코드를 보니까 다 있다.. 하아ㅏㅏ아
    @Test
    fun `쉼표 테스트`() {
        val input = "이동수 소진호"
        assertThrows<IllegalArgumentException> {

        }
    }
    @Test
    fun `우테코 전용 코드`() {
        assertRandomNumberInRangeTest(
            {
                run("dong,zino","5")
                assertThat(output()).contains("")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `5글자가 넘어가면 오류가 발생하나`() {

    }

    @Test
    fun `시도 횟수가 자연수로 입력이 안되면 오류가 발생하나`() {

    }

    @Test
    fun `0~9 무작위 값이 잘나오나`() {

    }

    @Test
    fun `무작위 값이 4 이상일때만 전진하나`() {

    }

    @Test
    fun `우승자가 여러명일때 (,)로 구분돼서 출력되나`() {

    }


    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
