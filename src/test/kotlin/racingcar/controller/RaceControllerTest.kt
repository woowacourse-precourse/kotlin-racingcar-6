package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.TestCarFactory
import racingcar.model.TestCarFactory.CarType.*
import racingcar.model.TurnNumber
import racingcar.model.car.CarName
import racingcar.view.RaceView
import racingcar.view.TestInputView
import racingcar.view.TestOutputView

class RaceControllerTest {
    private lateinit var controller: RaceController
    private lateinit var inputView: TestInputView
    private lateinit var outputView: TestOutputView
    private lateinit var carFactory: TestCarFactory

    @BeforeEach
    fun setUp() {
        inputView = TestInputView()
        outputView = TestOutputView()
        carFactory = TestCarFactory()

        controller = RaceController(
            raceView = RaceView(inputView = inputView, outputView = outputView),
            carFactory = carFactory
        )
    }

    @Test
    fun startRace_userEnterValidInputs_printRaceResultCorrectly() {
        // given
        inputView.addUserInput("pobi,woni,jun", "5")

        // when
        controller.startRace()

        // then
        // 처음 입력을 위한 출력 2개와 "실행 결과"는 항상 동일하게 출력되므로 버림
        val capturedTexts = outputView.capturedTexts.drop(3)
        println(outputView.capturedTexts)

        // 5번 레이스를 시도하므로 결과도 5번씩 나와야 정상
        assertThat(capturedTexts.count { "pobi : " in it }).isEqualTo(5)
        assertThat(capturedTexts.count { "woni : " in it }).isEqualTo(5)
        assertThat(capturedTexts.count { "jun : " in it }).isEqualTo(5)
    }

    @Test
    fun startRace_userEnterValidInputs_printRaceWinnerCorrectly() {
        // given
        inputView.addUserInput("pobi,woni,jun", "5")
        carFactory.setCarTypeOf(
            CarName("pobi") to NEVER_GO_FORWARD,
            CarName("woni") to ALWAYS_GO_FORWARD, // 우승자는 woni
            CarName("jun") to NEVER_GO_FORWARD
        )

        // when
        controller.startRace()

        // then
        // 처음 입력을 위한 출력 2개와 "실행 결과"는 항상 동일하게 출력되므로 버림
        val capturedTexts = outputView.capturedTexts.drop(3)
        println(outputView.capturedTexts)

        assertThat(capturedTexts.last()).isEqualTo("최종 우승자 : woni")
    }

    @Test
    fun startRace_userEnterValidInputs_printMultipleRaceWinnersCorrectly() {
        // given
        inputView.addUserInput("pobi,woni,jun", "5")
        carFactory.setCarTypeOf(
            CarName("pobi") to NEVER_GO_FORWARD,
            CarName("woni") to ALWAYS_GO_FORWARD, // 우승자는 woni
            CarName("jun") to ALWAYS_GO_FORWARD // 우승자는 jun
        )

        // when
        controller.startRace()

        // then
        // 처음 입력을 위한 출력 2개와 "실행 결과"는 항상 동일하게 출력되므로 버림
        val capturedTexts = outputView.capturedTexts.drop(3)
        println(outputView.capturedTexts)

        assertThat(capturedTexts.last()).isEqualTo("최종 우승자 : woni, jun")
    }

    @Test
    fun startRace_userEnterSomeNamesWhoseLengthIsLongerThan5_throwIllegalArgumentException() {
        // given
        inputView.addUserInput("pobi,woni,jun,longname", "5")

        // when
        val exception = assertThrows<IllegalArgumentException> {
            controller.startRace()
        }

        // then
        assertThat(exception.message).isEqualTo(CarName.CAR_NAME_LENGTH_EXCEPTION)
    }

    @Test
    fun startRace_userEnterEmptyLineForCarNames_onlyPrintWinnerTitle() {
        // given
        inputView.addUserInput("", "5")

        // when
        controller.startRace()

        // then
        // 처음 입력을 위한 출력 2개와 "실행 결과"는 항상 동일하게 출력되므로 버림
        val capturedTexts = outputView.capturedTexts.drop(3)
        println(outputView.capturedTexts)

        assertThat(capturedTexts.size).isEqualTo(1)
        assertThat(capturedTexts[0]).isEqualTo("최종 우승자 : ")
    }

    @Test
    fun startRace_userEnterNegativeNumberForTurnNumber_throwIllegalArgumentException() {
        // given
        inputView.addUserInput("pobi,woni,jun", "-1")

        // when
        val exception = assertThrows<IllegalArgumentException> {
            controller.startRace()
        }

        // then
        assertThat(exception.message).isEqualTo(TurnNumber.LESS_THAN_MIN_TURN_NUMBER)
    }

    @Test
    fun startRace_userEnterZeroNumberForTurnNumber_noRaceResultCaptured() {
        // given
        inputView.addUserInput("pobi,woni,jun", "0")

        // when
        controller.startRace()

        // then
        // 처음 입력을 위한 출력 2개와 "실행 결과"는 항상 동일하게 출력되므로 버림
        val capturedTexts = outputView.capturedTexts.drop(3)
        println(outputView.capturedTexts)

        assertThat(capturedTexts).doesNotContain("pobi : ")
        assertThat(capturedTexts).doesNotContain("woni : ")
        assertThat(capturedTexts).doesNotContain("jun : ")
    }

    @Test
    fun startRace_userEnter0ForTurnNumber_printEveryCarAsWinner() {
        // given
        inputView.addUserInput("pobi,woni,jun", "0")

        // when
        controller.startRace()

        // then
        // 처음 입력을 위한 출력 2개와 "실행 결과"는 항상 동일하게 출력되므로 버림
        val capturedTexts = outputView.capturedTexts.drop(3)
        println(outputView.capturedTexts)

        assertThat(capturedTexts[0]).isEqualTo("최종 우승자 : pobi, woni, jun")
    }
}