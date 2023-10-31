package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.service.WinnerService
import racingcar.util.ValidationUtil
import racingcar.view.InputView
import racingcar.view.OutputView

object GameController {

    fun playRacingGame() {
        val (cars, numberOfRounds) = initializeGameSettings()
        val racingGame = RacingGame(cars, numberOfRounds)
        val roundResults = racingGame.start()

        OutputView.printRoundResults(roundResults)
        OutputView.printWinners(WinnerService.findWinners(roundResults.last()))
    }

    fun initializeGameSettings(): Pair<List<Car>, Int> {
        val carNames = getValidCarNames()
        val cars = carNames.map { Car(it) }
        val numberOfRounds = getValidNumberOfRounds()
        return Pair(cars, numberOfRounds)
    }

    fun getValidCarNames(): List<String> {
        val userInputCarNames = InputView.readCarNames()
        val carNames = userInputCarNames.split(",")
        ValidationUtil.validateCarNames(carNames)
        return carNames
    }

    fun getValidNumberOfRounds(): Int {
        val userInputNumberOfRounds = InputView.readNumberOfRounds()
        ValidationUtil.validateNumberOfRounds(userInputNumberOfRounds)
        return userInputNumberOfRounds.toInt()
    }

}