package racingcar.view

import racingcar.model.TurnNumber
import racingcar.model.car.Car
import racingcar.model.car.CarName

class RaceView(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun displayEnterCarNames() {
        outputView.displayText(ENTER_CAR_NAMES)
    }

    fun getCarNamesFromUser(): List<CarName> {
        val userInput = inputView.readLine()
        return if (userInput.isEmpty()) emptyList() else userInput.split(',').map(::CarName)
    }

    fun displayEnterTurnNumber() {
        outputView.displayText(ENTER_TURN_NUMBER)
    }

    fun getTurnNumberFromUser(): TurnNumber {
        return TurnNumber(number = inputView.readInt())
    }

    fun displayRaceResultTitle() {
        outputView.displayText("\n$RESULT_TITLE") // 입력을 받고 한줄 띄우고 실행 결과 출력
    }

    fun displayRaceResult(cars: List<Car>) {
        cars.forEach { car -> car.showResult() }
        outputView.displayText("") // 한줄 띄우기
    }

    private fun Car.showResult() {
        val result = StringBuilder("$name : ")
        repeat(distance) { result.append(DISTANCE_MARKER) }
        outputView.displayText(result.toString())
    }

    fun displayWinners(winnerNames: List<CarName>) {
        val joinedCarNames = winnerNames.joinToString(WINNER_SEPARATOR)
        outputView.displayText("$WINNER : $joinedCarNames")
    }

    companion object {
        private const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val ENTER_TURN_NUMBER = "시도할 횟수는 몇 회인가요?"
        private const val RESULT_TITLE = "실행 결과"
        private const val DISTANCE_MARKER = '-'
        private const val WINNER = "최종 우승자"
        private const val WINNER_SEPARATOR = ", "
    }
}