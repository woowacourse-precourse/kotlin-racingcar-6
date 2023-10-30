package racingcar.game

import camp.nextstep.edu.missionutils.Randoms
import racingcar.utils.InputValidator.validateInputCarNames
import racingcar.utils.InputValidator.validateInputRoundCount
import racingcar.view.InputView.inputCarNames
import racingcar.view.InputView.inputRoundCount
import racingcar.view.OutputView.outputCurrentCarPositions
import racingcar.view.OutputView.outputFinalWinners
import racingcar.view.OutputView.outputResultTitle

object RacingGame {

    private const val RANDOM_MIN_NUM = 0
    private const val RANDOM_MAX_NUM = 9
    private const val MIN_NUM_TO_FORWARD = 4

    fun start() {
        val cars = inputCarNames()
        validateInputCarNames(cars)

        val roundCount = inputRoundCount()
        validateInputRoundCount(roundCount)

        outputResultTitle()

        repeat(roundCount) {
            moveCarsRandomly(cars)
            outputCurrentCarPositions(cars)
        }

        val winners = chooseWinners(cars)
        outputFinalWinners(winners)
    }

    private fun moveCarsRandomly(cars: List<Car>) {
        cars.forEach {
            if (isCarMovable()) it.position++
        }
    }

    private fun isCarMovable(): Boolean =
        Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= MIN_NUM_TO_FORWARD

    private fun chooseWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}