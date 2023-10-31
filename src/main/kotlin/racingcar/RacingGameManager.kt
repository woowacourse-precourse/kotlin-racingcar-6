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
        val cars = createCars(inputCarNameFromUser())
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

    private fun createCars(input: String): List<Car> {
        val cars = mutableListOf<Car>()

        input.split(",").forEach { name ->
            with(Validator) {
                checkCarNameLength(name)
                checkInputWhitespace(name.trim())
            }

            cars.add(Car(name))
        }
        return cars.toList()
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

    private fun setGameRound(): Int = inputGameRoundFromUser()

    private fun inputCarNameFromUser(): String {
        val carName = Console.readLine()

        with(Validator) {
            checkInputNonBlank(carName)
            checkInputOverSize(carName.split(",").size)
            checkCarMinSize(carName)
            checkInputPrefix(carName[0])
            checkInputPostfix(carName[carName.lastIndex])
        }

        return carName
    }

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