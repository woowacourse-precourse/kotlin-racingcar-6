package racingcar

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

object RacingGameManager {
    private lateinit var racingGame : RacingGame

    fun startGame() {
        racingGame = RacingGame(
            carList = InputHandler.getCarName(),
            amount = InputHandler.getAmount()
        )
    }





}