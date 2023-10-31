package racingcar.controller

import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun runRacingSimulation() {
        val carNames = inputView.inputCarNames()
        val tryCount = inputView.inputTryRaceCount()
        val cars: List<Cars> = carNames.map { Cars(it) }

        runRacingTrials(cars, tryCount)
        outputView.displayRaceWinners(cars)
    }


    private fun runRacingTrials(cars: List<Cars>, tryCount: Int) {
        outputView.printHeadResult()
        for (idx in 1..tryCount) {
            cars.map { it.chooseActionFromRandomNumber() }
            outputView.displayCarScores(cars)
        }
    }
}
