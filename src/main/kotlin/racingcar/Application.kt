package racingcar

import racingcar.controller.InputVerification.getCarNames
import racingcar.controller.InputVerification.getTryNumber
import racingcar.model.Game
import racingcar.view.Prompter

fun main() {
    Prompter.startGame()
    val cars = getCarNames()
    Prompter.tryGameNumber()
    val tryNumber = getTryNumber()
    Prompter.resultGame()
    val game = Game(cars)
    Prompter.showGame(game,tryNumber)
    Prompter.showWinner(game.getWinner())
}
