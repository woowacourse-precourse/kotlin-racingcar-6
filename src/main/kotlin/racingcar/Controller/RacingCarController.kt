package racingcar.Controller

import racingcar.Model.Race
import racingcar.View.InputView
import racingcar.View.OutputView


class RacingCarController { // 사용자의 입력이나 요청을 받아 처리하고 결과를 출력하는 로직을 담당
    companion object {
        private val inputView = InputView()
        private val outputView = OutputView()
        fun start() {
            val carNames = inputView.getCarNames()
            val tries = inputView.getRaceTries()

            val race = Race(carNames, tries)
            race.race()

            val winners = race.getWinners()
            outputView.printWinners(winners)
        }
    }
}
