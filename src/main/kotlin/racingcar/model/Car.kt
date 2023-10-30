package racingcar.model

import racingcar.inputView
import racingcar.validateCarName

class Car {
    private val soloRacingGame = SoloRacingGame()
    fun getCarName() {
        val inputCarName = inputView.inputView()
        validateCarName.validateInputBlank(inputCarName)
        checkSoloCar(inputCarName)
    }

    private fun checkSoloCar(inputCarName: String): Boolean {
        if (!inputCarName.contains(",")) {
            soloRacingGame.soloCarGame(inputCarName)
        } else {
            val multiCarName = inputCarName.split(",")
            validateCarName.validateInputMultiCarName(multiCarName)
        }
        return true
    }
}
