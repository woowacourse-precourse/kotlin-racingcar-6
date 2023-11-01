package racingcar.view

import racingcar.model.Car
import racingcar.util.GameMessage

class OutputView {
    fun inputCarName() {
        println(GameMessage.INPUT_CAR_NAME)
    }

    fun inputAttemptCount() {
        println(GameMessage.INPUT_ATTEMPT_COUNT)
    }

    fun outputGameResult() {
        println(GameMessage.OUTPUT_GAME_RESULT)
    }

    fun outputGameWinner() {
        print(GameMessage.OUTPUT_GAME_WINNER)
    }

    fun printCarListState(carList: List<Car>) {
        for (car in carList) {
            val carName = car.getName()
            val carDashes = "-".repeat(car.getPosition())
            print("$carName : $carDashes")
        }
    }

    fun printGameWinner(gameWinnerList: List<Car>) {
        println(gameWinnerList.joinToString(", "))
    }
}