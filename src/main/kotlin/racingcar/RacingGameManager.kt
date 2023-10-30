package racingcar

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

object RacingGameManager {
    private lateinit var racingGame : RacingGame
    private var racingGameTotalRounds = 0

    fun startGame() {
        racingGame = RacingGame(carList = InputHandler.getCarName())
        racingGameTotalRounds = InputHandler.getAmount()
        println("실행 결과")
        while (!isGameOver()){
            racingGame.initRound()
        }
    }
    private fun isGameOver() = racingGame.getCurrentGameRound() == racingGameTotalRounds

}