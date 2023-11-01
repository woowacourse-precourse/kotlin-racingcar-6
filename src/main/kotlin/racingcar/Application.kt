package racingcar

import racingcar.game.RacingGame
import racingcar.utils.InputValidator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val cars = InputView.inputCarNames()
    InputValidator.validateInputCarNames(cars)

    val roundCount = InputView.inputRoundCount()
    InputValidator.validateInputRoundCount(roundCount)

    OutputView.outputResultTitle()

    repeat(roundCount) {
        RacingGame.moveCarsRandomly(cars)
        OutputView.outputCurrentCarPositions(cars)
    }

    val winners = RacingGame.chooseWinners(cars)
    OutputView.outputFinalWinners(winners)
}