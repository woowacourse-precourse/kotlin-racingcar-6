package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.CarGroup
import racingcar.model.Judge
import racingcar.view.OutputView

class Controller {

    private val outputView = OutputView()

    fun start() {
        outputView.printInputRaceCarNames()
        val cars = CarGroup.from(Console.readLine())

        outputView.printInputNumberOfAttempts()
        val input = Console.readLine()
        val number = input.validateNumber().getOrThrow().toInt()

        val judge = Judge(cars)
        repeat(number) {
            outputView.printAllRaceResults(judge.play())
        }
        outputView.printWinner(judge.getWinner())
    }
}