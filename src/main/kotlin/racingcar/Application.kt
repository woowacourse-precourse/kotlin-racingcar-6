package racingcar

import racingcar.domain.Car
import racingcar.domain.Game
import racingcar.view.InputView
import racingcar.view.OutputView.printRaceWinner
import racingcar.view.OutputView.printResultMessage
import racingcar.view.OutputView.printStartMessage
import racingcar.view.OutputView.printTrialMessage

fun main() {
    printStartMessage()
    val names = InputView.inputCarName()
    val nameList = names?.split(",")
    val nameResult = nameList?.map { Car(it) }

    printTrialMessage()
    val trial = InputView.inputTrial()
    val game = Game()

    printResultMessage()
    repeat(trial) {
        game.start(nameResult)
        println()
    }

    val result = game.result(nameResult)
    val winnwer = game.awardWinner(result)
    printRaceWinner(winnwer)
}



