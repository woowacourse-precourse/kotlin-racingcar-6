package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.TurnNumber
import racingcar.model.car.CarName

class RaceViewTest {
    private lateinit var view: RaceView
    private lateinit var inputView: TestInputView
    private lateinit var outputView: TestOutputView

    @BeforeEach
    fun setUp() {
        inputView = TestInputView()
        outputView = TestOutputView()
        view = RaceView(inputView = inputView, outputView = outputView)
    }

    @Test
    fun getCarNamesFromUser_allEnteredNameLengthAreShorterThanOrEqualTo5_returnCarNames() {
        // given
        inputView.addUserInput("pobi,woni,jun,hello,world")

        // when
        val carNames = view.getCarNamesFromUser()

        // then
        val expectedCarNames = listOf(
            CarName("pobi"),
            CarName("woni"),
            CarName("jun"),
            CarName("hello"),
            CarName("world"),
        )
        assertThat(carNames).isEqualTo(expectedCarNames)
    }

    @Test
    fun getCarNamesFromUser_userEnterNamesLongerThan5_throwIllegalArgumentException() {
        // given
        inputView.addUserInput("pobi,woni,jun,longname")

        // when
        val exception = assertThrows<IllegalArgumentException> {
            view.getCarNamesFromUser()
        }

        // then
        assertThat(exception.message).isEqualTo(CarName.CAR_NAME_LENGTH_EXCEPTION)
    }

    @Test
    fun getCarNamesFromUser_userEnterEmptyLine_returnEmptyList() {
        // given
        inputView.addUserInput("")

        // when
        val carNames = view.getCarNamesFromUser()

        // then
        assertThat(carNames).isEmpty()
    }

    @Test
    fun getTurnNumberFromUser_userEnter0_returnTurnNumber() {
        // given
        inputView.addUserInput("0")

        // when
        val turnNumber = view.getTurnNumberFromUser()

        // then
        assertThat(turnNumber.number).isEqualTo(0)
    }

    @Test
    fun getTurnNumberFromUser_userEnterNegativeNumber_throwIllegalArgumentException() {
        // given
        inputView.addUserInput("-1")

        // when
        val exception = assertThrows<IllegalArgumentException> {
            view.getTurnNumberFromUser()
        }

        // then
        assertThat(exception.message).isEqualTo(TurnNumber.LESS_THAN_MIN_TURN_NUMBER)
    }

    @Test
    fun getTurnNumberFromUser_userEnterPositiveNumber_returnTurnNumber() {
        // given
        inputView.addUserInput("1")

        // when
        val turnNumber = view.getTurnNumberFromUser()

        // then
        assertThat(turnNumber.number).isEqualTo(1)
    }
}