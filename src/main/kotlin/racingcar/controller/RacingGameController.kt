package racingcar.controller

import racingcar.model.RacingBoard
import racingcar.view.RacingGameView

class RacingGameController {
    private val view = RacingGameView()
    fun run() {
        val racerList = view.inputCarNameList()
        val board = RacingBoard(racerList = racerList)

        val playCount = view.inputPlayCount()
        view.printResultMessage()
        repeat(playCount){
            board.play()
            view.printPlayResult(playResult = board.toString())
        }
        view.printResultWinner(winnerList = board.getResult())
    }
}