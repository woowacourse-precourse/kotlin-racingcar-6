package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.utils.Validator.validateInputCarNames
import racingcar.utils.Validator.validateInputRoundCount
import racingcar.view.InputView.inputCarNames
import racingcar.view.InputView.inputRoundCount
import racingcar.view.OutputView.outputCurrentCarPositions
import racingcar.view.OutputView.outputResultTitle

private const val RANDOM_MIN_NUM = 0
private const val RANDOM_MAX_NUM = 9
private const val MIN_NUM_TO_FORWARD = 4

fun main() {

    val cars = inputCarNames()
    validateInputCarNames(cars)

    val roundCount = inputRoundCount()
    validateInputRoundCount(roundCount)

    outputResultTitle()

    repeat(roundCount) {
        cars.forEach {
            if (Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= MIN_NUM_TO_FORWARD) it.position++
        }
        outputCurrentCarPositions(cars)
    }

    val maxPosition = cars.maxOf { it.position }
    val winnerCars = cars.filter { it.position == maxPosition }
}
