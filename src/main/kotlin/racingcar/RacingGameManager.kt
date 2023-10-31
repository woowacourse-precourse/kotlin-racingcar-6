package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.data.Car

class RacingGameManager {

    private val carController = CarController()

    private val gameRound: Int by lazy {
        setGameRound()
    }

    fun run() {
        printGameStart()
        carController.createCars()
        printGameRoundQuestion()

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
            printGameEnd()
        }
    }

    private fun printGameStart() = println(Message.INPUT_CAR_NAME.message)

    private fun printGameRoundQuestion() = println(Message.INPUT_GAME_ROUND.message)
    private fun printGameEnd() = println(Message.OUTPUT_GAME_END.message)
    private fun printGameResultPerGameRound(cars: List<Car>) {
        val stringBuilder = StringBuilder()

        cars.forEach { car ->
            stringBuilder.append(car.name).append(" : ")
            (1..car.distance).forEach { _ ->
                stringBuilder.append("-")
            }
            println(stringBuilder)
            stringBuilder.clear()
        }
    }

    private fun printWinners(winners: List<Car>) {
        println(Message.OUTPUT_GAME_WINNER_PREFIX.message.plus(winners.joinToString()))
    }

    private fun setGameRound(): Int = inputGameRoundFromUser()

    private fun inputGameRoundFromUser(): Int {
        val gameRound = Console.readLine()

        with(Validator) {
            checkIntType(gameRound)
            checkGameRoundSize(gameRound.toInt())
        }

        return gameRound.toInt()
    }

    private fun closeConsole() = Console.close()
}