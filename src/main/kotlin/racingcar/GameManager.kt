package racingcar

import racingcar.Constants.TRIAL_RESULT

object GameManager {

    private lateinit var gameResult: List<RacingCar>

    fun startGame() {
        val gameSettings = InputManager.getGameSettings()
        gameResult = gameSettings.carList
        println(TRIAL_RESULT)
        for (i in 1..gameSettings.trialNum) {
            gameResult = RacingGame.getResult(gameResult)
        }

        val resultManager = ResultManager(gameResult)
        resultManager.logWinner()
    }
}