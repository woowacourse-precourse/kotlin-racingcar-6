package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.TurnNumber
import racingcar.model.car.Car
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

    @Test
    fun displayRaceResult_carsAreGiven_printCarNameAndDistanceMarkerCorrectly() {
        // given
        val cars = listOf(
            createCarWithNameAndDistance(CarName("pobi"), 4),
            createCarWithNameAndDistance(CarName("woni"), 5),
            createCarWithNameAndDistance(CarName("jun"), 6),
        )

        // when
        view.displayRaceResult(cars = cars)

        // then
        assertThat(outputView.capturedTexts[0]).isEqualTo("pobi : ----")
        assertThat(outputView.capturedTexts[1]).isEqualTo("woni : -----")
        assertThat(outputView.capturedTexts[2]).isEqualTo("jun : ------")
    }

    @Test
    fun displayRaceResult_emptyListGiven_printNothing() {
        // given
        val cars = emptyList<Car>()

        // when
        view.displayRaceResult(cars = cars)

        // then
        assertThat(outputView.capturedTexts).isEmpty()
    }

    @Test
    fun displayWinners_winnerNameIsGiven_printWinnerName() {
        // given
        val winnerNames = listOf(CarName("pobi"))

        // when
        view.displayWinners(winnerNames = winnerNames)

        // then
        assertThat(outputView.capturedTexts[0]).isEqualTo("최종 우승자 : pobi")
    }

    @Test
    fun displayWinners_multipleWinnerNamesAreGiven_printWinnerNamesJoinedByComma() {
        // given
        val winnerNames = listOf(
            CarName("pobi"),
            CarName("woni"),
            CarName("jun"),
        )

        // when
        view.displayWinners(winnerNames = winnerNames)

        // then
        assertThat(outputView.capturedTexts[0]).isEqualTo("최종 우승자 : pobi, woni, jun")
    }

    @Test
    fun displayWinners_emptyListGiven_onlyPrintWinnerTitle() {
        // given
        val winnerNames = emptyList<CarName>()

        // when
        view.displayWinners(winnerNames = winnerNames)

        // then
        assertThat(outputView.capturedTexts[0]).isEqualTo("최종 우승자 : ")
    }

    // region helper functions

    private fun createCarWithNameAndDistance(name: CarName, distance: Int): Car {
        val car = Car(name = name, randomNumberGenerator = alwaysGoForward)
        repeat(distance) { car.tryGoForward() }
        return car
    }

    companion object {
        private val alwaysGoForward: (Int, Int) -> Int = { _, _ -> 9 }
    }

    // endregion
}