package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.Constants.EXCEPTION_CAR_NAME_LENGTH
import racingcar.Constants.EXCEPTION_CAR_NAME_STARTS_WITH_BLANK
import racingcar.Constants.EXCEPTION_CAR_NUM
import racingcar.Constants.EXCEPTION_TRIAL_NUM

class ApplicationTest : NsTest() {

    //===================================자동차 이름 입력 및 실행 횟수 입력=============================================
    @Test
    fun `정상적인 자동차명 입력으로 RacingCar 객체의 리스트 반환`() {
        val input = "kmkim,kkm,kmk"
        val actualOutput = InputManager.getCarList(input)
        val expectedOutput = listOf(
            RacingCar("kmkim", 0),
            RacingCar("kkm", 0),
            RacingCar("kmk", 0),
        )
        assertThat(actualOutput).isEqualTo(expectedOutput)
    }

    @Test
    fun `1개의 자동차 입력에 대한 예외 처리`() {
        val input = "kmkim"
        assertThrows<IllegalArgumentException>(EXCEPTION_CAR_NUM) {
            InputManager.getCarList(input)
        }
    }

    @Test
    fun `공백으로 시작하는 자동차명에 대한 예외 처리`() {
        val input = "kmkim, ,kkm"
        assertThrows<IllegalArgumentException>(EXCEPTION_CAR_NAME_STARTS_WITH_BLANK) {
            InputManager.getCarList(input)
        }
    }

    @Test
    fun `여섯 글자를 초과하는 자동차명에 대한 예외 처리`() {
        val input = "kmkim2689,kkm"
        assertThrows<IllegalArgumentException>(EXCEPTION_CAR_NAME_LENGTH) {
            InputManager.getCarList(input)
        }
    }

    @Test
    fun `0글자 자동차명 대한 예외 처리`() {
        val input = "kmkim2689,,kkm"
        assertThrows<IllegalArgumentException>(EXCEPTION_CAR_NAME_LENGTH) {
            InputManager.getCarList(input)
        }
    }

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

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
