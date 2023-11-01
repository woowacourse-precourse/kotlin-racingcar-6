package racingcar.Controller

import RacingGameModel
import racingcar.View.RacingGameView

object RacingGameController {
    fun gameStart(){

        val racingGameModel = RacingGameView.inputCarNames()
        val playTime = RacingGameView.inputPlayTime()

        racingGameModel.playTime = playTime

        racingGameModel.playGame()

        val winners = racingGameModel.findWinnerByCount()
        RacingGameView.printWinner(winners)

    }
}