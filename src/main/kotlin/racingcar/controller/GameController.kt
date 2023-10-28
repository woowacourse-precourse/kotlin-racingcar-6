package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    companion object {
        const val COMMA_DELIMITERS = ','
    }

    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()

    fun start() {
        val carNamesInput = inputView.promptCarNames()
        val carNames = inputCarNames(carNamesInput)
        val cars = Cars(carNames.map { Car(it) })
    }

    // TODO: 최종 Test 이후, private으로 수정
    internal fun inputCarNames(carNames: String): List<String> {
        if (carNames.contains(COMMA_DELIMITERS)) {
            return carNames.split(COMMA_DELIMITERS).map { it.trim() }
        }
        return listOf(carNames.trim())
    }
}