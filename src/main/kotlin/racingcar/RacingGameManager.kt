package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.data.Car

class RacingGameManager {

    private val gameRound: Int by lazy {
        setGameRound()
    }

    fun run() {
        printGameStart()
        createCars()
        printGameRoundQuestion()

        repeat(gameRound) {
            // TODO
        }

        closeConsole()
    }

    private fun printGameStart() = println(Message.INPUT_CAR_NAME.message)

    private fun printGameRoundQuestion() = println(Message.INPUT_GAME_ROUND.message)

    private fun createCars(): List<Car> {
        val cars = mutableListOf<Car>()

        inputDataFromUser().let { carNames ->
            carNames.split(",").forEach { name ->
                cars.add(
                    Car(name = name
                        .filterNot {
                            it.isWhitespace()
                        }
                    )
                )
            }
        }

        return cars
    }

    private fun setGameRound(): Int = inputDataFromUser().toInt()

    private fun inputDataFromUser(): String = Console.readLine()

    private fun closeConsole() = Console.close()
}