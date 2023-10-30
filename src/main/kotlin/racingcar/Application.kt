package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.InputView.inputCarNames
import racingcar.view.InputView.inputRoundCount
import racingcar.view.OutputView.outputCurrentCarPositions
import racingcar.view.OutputView.outputResultTitle

private const val RANDOM_MIN_NUM = 0
private const val RANDOM_MAX_NUM = 9
private const val MIN_NUM_TO_FORWARD = 4

fun main() {

    val carNames = inputCarNames()
    val roundCount = inputRoundCount()

    outputResultTitle()

    repeat(roundCount) {
        carNames.forEach {
            if (Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= MIN_NUM_TO_FORWARD) it.position++
        }
        outputCurrentCarPositions(carNames)
    }
}
