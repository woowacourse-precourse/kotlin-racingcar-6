package racingcar.controller

import racingcar.model.Car
import racingcar.model.MultiRacingGame
import racingcar.model.SoloRacingGame
import racingcar.model.ValidateCarName
import racingcar.model.ValidateRacingCount
import racingcar.utils.RandomUtils
import racingcar.views.InputView
import racingcar.views.OutputView

class GameController {

    private val inputView = InputView()
    private val randomUtils = RandomUtils()
    private val outputView = OutputView()
    private val validateRacingCount = ValidateRacingCount()
    private val soloRacingCount = SoloRacingGame(randomUtils, outputView)
    private val multiRacingGame = MultiRacingGame(inputView, randomUtils, validateRacingCount, outputView)
    private val validateCarName = ValidateCarName()
    private val car = Car(validateCarName, soloRacingCount, multiRacingGame)

    fun gameStart() {
        inputView.gameStartMessage()
        val inputCarName = inputView.inputView()
        car.getCarName(inputCarName)
    }
}
