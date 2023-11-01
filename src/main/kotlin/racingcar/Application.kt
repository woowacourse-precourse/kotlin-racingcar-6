package racingcar

import racingcar.domain.Car
import racingcar.domain.Game
import racingcar.utils.Constants.RESULT_MESSAGE
import racingcar.view.InputView
import racingcar.view.OutputView.printRaceWinner

fun main() {

    val names = InputView.inputCarName()
    val nameList = names?.split(",")
    val nameResult = nameList?.map { Car(it) }
    val trial = InputView.inputTrial()
    val game = Game()
    print(RESULT_MESSAGE)

    repeat(trial) {
        game.start(nameResult)
        println()
    }

}

