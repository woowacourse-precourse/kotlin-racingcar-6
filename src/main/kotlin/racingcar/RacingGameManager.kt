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
        val cars = createCars(inputDataFromUser())
        printGameRoundQuestion()

        repeat(gameRound) { round ->
            if (round == 0) {
                println()
                printGameEnd()
            }

            moveCarsForward(cars)
            printGameResultPerGameRound(cars)
            println()
        }

        printWinners(findWinners(cars, findMaxDistanceCar(cars)))
        closeConsole()
    }

    private fun printGameStart() = println(Message.INPUT_CAR_NAME.message)

    private fun printGameRoundQuestion() = println(Message.INPUT_GAME_ROUND.message)
    private fun printGameEnd() = println(Message.OUTPUT_GAME_END.message)
    private fun printGameResultPerGameRound(cars: List<Car>) {
        val stringBuilder = StringBuilder()

        cars.forEach { car ->
            stringBuilder.append(car.toString())
            (1..car.distance).forEach { _ ->
                stringBuilder.append("-")
            }
            println(stringBuilder)
            stringBuilder.clear()
        }
    }

    private fun printWinners(winners: List<Car>) = println("최종 우승자 : ${winners.joinToString(", ")}")

    private fun createCars(input: String): List<Car> {
        val cars = mutableListOf<Car>()

        input.split(",").forEach { name ->
            if (hasNotCarNameWhitespace(name)) {
                cars.add(Car(name))
            }
        }
        return cars.toList()
    }

    private fun hasNotCarNameWhitespace(name: String): Boolean {
        Validator.checkInputWhitespace(name.trim())
        return true
    }

    private fun moveCarsForward(cars: List<Car>) {
        cars.forEach { car ->
            if (isCarMovingAllowed(generateRandomNumber())) {
                car.addDistance()
            }
        }
    }

    private fun isCarMovingAllowed(randomNumber: Int): Boolean = when (randomNumber) {
        in 4..9 -> true
        else -> false
    }

    private fun findWinners(cars: List<Car>, maxDistanceCar: Car?): List<Car> {
        val winners = cars.filter { car ->
            car.distance == maxDistanceCar?.distance
        }

        return winners
    }

    private fun findMaxDistanceCar(cars: List<Car>): Car? {
        return cars.maxByOrNull { car -> car.distance }
    }

    private fun generateRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

    private fun setGameRound(): Int = inputDataFromUser().toInt()

    private fun inputDataFromUser(): String {
        val inputData = Console.readLine()

        Validator.let {
            it.checkInputNonBlank(inputData)
            it.checkInputOverSize(inputData.split(",").size)
        }

        return inputData
    }

    private fun closeConsole() = Console.close()
}