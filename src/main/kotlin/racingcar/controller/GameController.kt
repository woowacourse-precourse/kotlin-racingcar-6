package racingcar.controller

import racingcar.model.Car
import racingcar.model.GameReferee
import racingcar.model.GameState
import racingcar.model.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val gameReferee = GameReferee()
    private var carList = listOf<Car>()
    private var gameState = GameState.START
    private var attemptCount = 0


    fun run() {
        while (gameState != GameState.EXIT) {
            proceed()
        }
    }
    private fun proceed() {
        when(gameState) {
            GameState.START -> {
                carList = createCarList()
                attemptCount = createAttemptCount()
                gameState = GameState.RACING
            }
            GameState.RACING -> {
                raceCar(carList, attemptCount)
                gameState = GameState.FINISHED
            }
            GameState.FINISHED -> {
                announceGameWinner()
                gameState = GameState.EXIT
            }
            GameState.EXIT -> {
                return
            }
            else -> throw IllegalArgumentException("존재하지 않은 게임상태: $gameState")
        }
    }

    private fun createCarList(): List<Car> {
        outputView.inputCarName()
        return inputView.inputCarList()
    }

    private fun createAttemptCount(): Int {
        outputView.inputAttemptCount()
        return inputView.inputAttemptCount()
    }

    private fun forwardCar(carList: List<Car>) {
        for(car in carList) {
            val randomNumber = RandomNumberGenerator.run()
            if (gameReferee.validatePossibleForward(randomNumber)) {
                car.move()
            }
        }
    }

    private fun raceCar(carList: List<Car>, attemptCount: Int) {
        outputView.outputGameResult()
        for(count in 0..< attemptCount) {
            forwardCar(carList)
            outputView.printCarListState(carList)
        }
    }

    private fun announceGameWinner() {
        val highestScore = gameReferee.calculateHighestScore(carList)
        val gameWinnerList = gameReferee.determineGameWinner(carList, highestScore)
        outputView.printGameWinner(gameWinnerList)
    }
}