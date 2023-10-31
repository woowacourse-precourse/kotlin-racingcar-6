package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.Constants.EXCEPTION_CAR_NAME_DUPLICATION
import racingcar.Constants.EXCEPTION_CAR_NAME_LENGTH
import racingcar.Constants.EXCEPTION_CAR_NAME_STARTS_WITH_BLANK
import racingcar.Constants.EXCEPTION_CAR_NUM
import racingcar.Constants.EXCEPTION_TRIAL_NUM

class ApplicationTest : NsTest() {

    private lateinit var resultManager: ResultManager

    @BeforeEach
    fun setUp() {
        val input = listOf(
            RacingCar("kmkim", 3),
            RacingCar("kmk", 2),
            RacingCar("kkm", 1),
            RacingCar("km", 2),
            RacingCar("kkk", 3),
        )

        resultManager = ResultManager(input)
    }

    //=================================== 자동차 이름 입력 및 실행 횟수 입력 =============================================
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
        val input = "kmkim,,kkm"
        assertThrows<IllegalArgumentException>(EXCEPTION_CAR_NAME_LENGTH) {
            InputManager.getCarList(input)
        }
    }

    @Test
    fun `중복된 자동차명 대한 예외 처리`() {
        val input = "kkm,kkm"
        assertThrows<IllegalArgumentException>(EXCEPTION_CAR_NAME_DUPLICATION) {
            InputManager.getCarList(input)
        }
    }

    @Test
    fun `문자열 형태의 숫자를 실행 횟수로 입력함에 대한 Long 형태의 실행 횟수 반환`() {
        val input = "12"
        val expectedOutput = InputManager.getTrialNum(input)
        assertThat(expectedOutput).isEqualTo(12L)
    }

    @Test
    fun `공백을 실행 횟수로 입력함에 대한 예외 처리`() {
        val input = " "
        assertThrows<IllegalArgumentException>(EXCEPTION_TRIAL_NUM) {
            InputManager.getTrialNum(input)
        }
    }

    @Test
    fun `빈 문자열을 실행 횟수로 입력함에 대한 예외 처리`() {
        val input = ""
        assertThrows<IllegalArgumentException>(EXCEPTION_TRIAL_NUM) {
            InputManager.getTrialNum(input)
        }
    }

    @Test
    fun `한글을 실행 횟수로 입력함에 대한 예외 처리`() {
        val input = "횟수"
        assertThrows<IllegalArgumentException>(EXCEPTION_TRIAL_NUM) {
            InputManager.getTrialNum(input)
        }
    }

    @Test
    fun `특수문자를 실행 횟수로 입력함에 대한 예외 처리`() {
        val input = "^"
        assertThrows<IllegalArgumentException>(EXCEPTION_TRIAL_NUM) {
            InputManager.getTrialNum(input)
        }
    }

    @Test
    fun `영문자 실행 횟수로 입력함에 대한 예외 처리`() {
        val input = "k"
        assertThrows<IllegalArgumentException>(EXCEPTION_TRIAL_NUM) {
            InputManager.getTrialNum(input)
        }
    }

    //============================================ 자동차 경주 1회 실행 ===================================================
    @Test
    fun `1세트의 경주에 대한 결과 반환`() {
        val racingCars = listOf(
            RacingCar(name = "kmk", 1),
            RacingCar(name = "kk", 2),
            RacingCar(name = "kkk", 5),
        )
        val numbers = listOf(3, 4, 5)

        val actualOutput = RacingGame.determineMoves(racingCars, numbers)
        val expectedOutput = listOf(
            RacingCar(name = "kmk", 1),
            RacingCar(name = "kk", 3),
            RacingCar(name = "kkk", 6),
        )

        assertThat(actualOutput).isEqualTo(expectedOutput)
    }
    //============================================== 최종 결과 산출 ======================================================
    @Test
    fun `RacingCar의 리스트 형태 투입에 대한 우승자 반환`() {
        val actualOutput = resultManager.determineWinners()
        assertThat(actualOutput).isEqualTo(listOf("kmkim", "kkk"))
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
