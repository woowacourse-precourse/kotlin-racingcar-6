package racingcar.controller

import racingcar.model.*
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
    private val validateCarName = ValidateCarName(multiRacingGame)
    private val car = Car(inputView, validateCarName, soloRacingCount)

    fun gameStart() {
        inputView.gameStartMessage()
        car.getCarName()
    }
}
