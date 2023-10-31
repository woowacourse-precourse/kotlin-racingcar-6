package racingcar.model

import racingcar.views.InputView

class Car(
    private val inputView: InputView,
    private val validateCarName: ValidateCarName,
    private val soloRacingGame: SoloRacingGame,
) {

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
