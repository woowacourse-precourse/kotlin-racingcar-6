package racingcar.view

import racingcar.model.Car
import racingcar.util.GameMessage
import java.lang.StringBuilder

class OutputView {
    fun printGameStartMessage() = println(GameMessage.GAME_START_MESSAGE)
    fun printGameInputAttemptMessage() = println(GameMessage.GAME_INPUT_ATTEMPT_MESSAGE)
    fun printGameResultMessage() = println(GameMessage.GAME_RESULT_MESSAGE)
    fun printGameWinnerMessage(winners: List<Car>) {
        val message = StringBuilder()
        message.append("${GameMessage.GAME_WINNER_MESSAGE} ")
        message.append(winners.joinToString { it.name })
        println(message.toString())
    }

    fun printGameStatusMessage(cars: List<Car>) {
        for (car in cars) {
            println(car)
        }
        println()
    }
}