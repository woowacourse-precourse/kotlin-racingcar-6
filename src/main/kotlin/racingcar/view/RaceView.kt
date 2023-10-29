package racingcar.view

import racingcar.model.CarName
import racingcar.model.TurnNumber

class RaceView(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun displayEnterCarNames() {
        outputView.displayText(ENTER_CAR_NAMES)
    }

    fun getCarNamesFromUser(): List<CarName> {
        return inputView.readLine().split(",").map(::CarName)
    }

    fun displayEnterTurnNumber() {
        outputView.displayText(ENTER_TURN_NUMBER)
    }

    fun getTurnNumberFromUser(): TurnNumber {
        return TurnNumber(number = inputView.readInt())
    }

    companion object {
        private const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val ENTER_TURN_NUMBER = "시도할 횟수는 몇 회인가요?"
    }
}