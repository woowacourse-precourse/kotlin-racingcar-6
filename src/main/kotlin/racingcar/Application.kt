package racingcar

import racingcar.view.InputView.inputCarNames
import racingcar.view.InputView.inputRoundCount
import racingcar.view.OutputView.outputResultTitle

fun main() {
    val carNames = inputCarNames()
    val roundCount = inputRoundCount()

    outputResultTitle()
}
