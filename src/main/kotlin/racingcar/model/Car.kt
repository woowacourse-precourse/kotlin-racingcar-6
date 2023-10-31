package racingcar.model

import racingcar.views.InputView

class Car(
    private val inputView: InputView,
    private val validateCarName: ValidateCarName,
    private val soloRacingGame: SoloRacingGame,
    private val multiRacingGame: MultiRacingGame
) {

    fun getCarName() {
        val inputCarName = inputView.inputView()
        checkSoloCar(inputCarName)
    }

    private fun checkSoloCar(inputCarName: String): Boolean {
        if (!inputCarName.contains(",")) {
            validateAndStartSoloRace(inputCarName)
        } else {
            validateAndStartMultiRace(inputCarName)
        }
        return true
    }

    private fun validateAndStartSoloRace(inputCarName: String) {
        validateCarName.validateInputSingleCarName(inputCarName)
        soloRacingGame.soloCarGame(inputCarName)
    }

    private fun validateAndStartMultiRace(inputCarName: String) {
        val multiCarName = inputCarName.split(",")
        validateCarName.validateInputMultiCarName(multiCarName)
        multiRacingGame.inputTryCount(multiCarName)
    }
}
