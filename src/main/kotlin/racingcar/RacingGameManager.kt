package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.controller.CarController
import racingcar.data.Car
import racingcar.validator.InputValidator

class RacingGameManager {

    private val carController = CarController()

    private val gameRound: Int by lazy {
        setGameRound()
    }

    fun run() {
        println(Message.INPUT_CAR_NAME.message)
        carController.createCars()
        println(Message.INPUT_GAME_ROUND.message)

        handleGameRounds(gameRound)

        printWinners(carController.findWinners())
        closeConsole()
    }

    private fun handleGameRounds(gameRound: Int) {
        repeat(gameRound) { round ->
            printGameResultOverview(round)

            carController.moveCarsForward()
            printGameResultPerGameRound(carController.getCars())
            println()
        }
    }

    private fun printGameResultOverview(round: Int) {
        if (round == 0) {
            println()
            println(Message.OUTPUT_GAME_END.message)
        }
    }

    private fun printGameResultPerGameRound(cars: List<Car>) {
        val stringBuilder = StringBuilder()

        cars.forEach { car ->
            stringBuilder.append("${car.name} : ")

            repeat(car.distance) {
                stringBuilder.append("-")
            }

            println(stringBuilder)
            stringBuilder.clear()
        }
    }

    private fun printWinners(winners: List<String>) {
        println("${Message.OUTPUT_GAME_WINNER_PREFIX.message}${winners.joinToString()}")
    }

    private fun setGameRound(): Int = inputGameRoundFromUser()

    private fun inputGameRoundFromUser(): Int {
        val gameRound = Console.readLine()

        with(InputValidator) {
            checkIntType(gameRound)
            checkGameRoundSize(gameRound.toInt())
        }

        return gameRound.toInt()
    }

    private fun closeConsole() = Console.close()
}