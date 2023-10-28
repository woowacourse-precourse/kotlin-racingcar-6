package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.Repetition
import racingcar.model.Winner
import racingcar.utils.Round
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    companion object {
        const val COMMA_DELIMITERS = ','
    }

    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()

    fun start() {
        val carNames = inputCarNames(inputView.promptCarNames())
        val cars = Cars(carNames.map { Car(it.trim()) })

        val repetition = Repetition(inputView.promptRepetition())

        repeat(repetition.count) {
            playRound(cars)
            outputView.printRoundResult(cars)
        }
        playResult(cars)
    }

    // TODO: 최종 Test 이후, private으로 수정
    internal fun inputCarNames(carNames: String): List<String> {
        if (carNames.contains(COMMA_DELIMITERS)) {
            return carNames.split(COMMA_DELIMITERS)
        }
        return listOf(carNames)
    }

    private fun playRound(cars: Cars) {
        for (car in cars.carList) {
            val randomNumber = Round.generateRandomNumber()
            if (Round.isForward(randomNumber)) {
                car.moveForward()
            }
        }
    }

    private fun playResult(cars: Cars) {
        val winner = Winner(cars.carList)
        outputView.printWinner(winner)
    }

}