package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.CarGroup
import racingcar.model.Judge
import racingcar.view.OutputView

class Controller {

    private val outputView = OutputView()

    fun start() {
        outputView.printInputRaceCarNames()
        val cars = CarGroup(Console.readLine())

        outputView.printInputNumberOfAttempts()
        val input = Console.readLine()

        require(input.isInt()) { "숫자를 입력해주세요." }
        val number = input.toInt()

        val judge = Judge(cars)
        repeat(number) {
            outputView.printAllRaceResults(judge.play())
        }
        outputView.printWinner(judge.getWinner())
    }
}

fun String.isInt(): Boolean = toIntOrNull() != null