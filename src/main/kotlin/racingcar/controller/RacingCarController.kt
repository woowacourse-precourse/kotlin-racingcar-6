package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(private val inputView: InputView, private val outputView: OutputView) {
    fun racingRun() {
        val carNames = inputView.inputCarName()
        val tryCount = inputView.inputTryRaceCount()
        val cars: List<Cars> = carNames.map { Cars(it) }

        tryRacing(cars, tryCount)
        outputView.raceWinners(cars)
    }


    private fun tryRacing(cars: List<Cars>, tryCount: Int) {
        outputView.printHeadResult()
        for (idx in 1..tryCount) {
            cars.map { it.chooseActionFromRandomNumber() }
            outputView.printScore(cars)
        }
    }
}
