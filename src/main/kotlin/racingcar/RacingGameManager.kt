package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.data.Car

class RacingGameManager {

    private val gameRound: Int by lazy {
        setGameRound()
    }

    fun run() {
        printGameStart()
        val cars = createCars()
        printGameRoundQuestion()

        repeat(gameRound) {
            createMoveNumberOfCars(cars)
        }

        printGameEnd()
        closeConsole()
    }

    private fun printGameStart() = println(Message.INPUT_CAR_NAME.message)

    private fun printGameRoundQuestion() = println(Message.INPUT_GAME_ROUND.message)
    private fun printGameEnd() = println(Message.OUTPUT_GAME_END.message)

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

    private fun createMoveNumberOfCars(cars: List<Car>) {
        cars.forEach { car ->
            car.changeMove(generateRandomNumber())
        }
    }

    private fun isMoveCar(randomNumber: Int): Boolean = when (randomNumber) {
        in 4..9 -> true
        else -> false
    }

    private fun generateRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

    private fun setGameRound(): Int = inputDataFromUser().toInt()

    private fun inputDataFromUser(): String = Console.readLine()

    private fun closeConsole() = Console.close()
}