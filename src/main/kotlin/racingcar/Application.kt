package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startRacingGame()
}

fun startRacingGame() {
    val cars = carNamesInput()

    val raceRound = roundInput()

    gameResult(raceRound, cars)
}

fun carNamesInput(): List<Cars> {
    println(Constants.CAR_NAME_INPUT_MESSAGE)
    val carNames = Console.readLine()
    val cars = carNames.split(Constants.CAR_NAMES_SPLITER).map { Cars(it) }
    validateCarNames(cars)
    return cars
}

fun validateCarNames(cars: List<Cars>) {
    if (cars.any { it.name.length > Constants.NAME_LENGTH_RULE }) {
        throw IllegalArgumentException(Constants.OVER_INPUT_ALARM)
    }
}

fun roundInput(): Int {
    println(Constants.ROUND_INPUT)
    val raceRound = Console.readLine().toInt()
    validateRaceRound(raceRound)
    return raceRound
}

fun validateRaceRound(raceRound: Int) {
    if (raceRound <= Constants.RACE_ROUND_RULE) {
        throw IllegalArgumentException(Constants.NOT_POSITIVE_INTEGER_ALARM)
    }
}

fun gameResult(inputRound: Int, cars: List<Cars>) {
    println(Constants.EXECUTION_RESULT)
    val racedCars = raceCars(inputRound, cars)
    printWinners(getWinners(racedCars))
}

fun raceCars(inputRound: Int, cars: List<Cars>): List<Cars> {
    repeat(inputRound) {
        cars.forEach { it.move() }
        printCarPositions(cars)
        println()
    }
    return cars
}

fun printCarPositions(cars: List<Cars>) {
    cars.forEach { car ->
        println("${car.name} : ${Constants.POSITION_MARK.repeat(car.position)}")
    }
}

fun getWinners(cars: List<Cars>): List<Cars> {
    val headPosition = cars.maxOf { it.position }
    return cars.filter { it.position == headPosition }
}

fun printWinners(winners: List<Cars>) {
    val winnersName = winners.map { it.name }
    println(Constants.FINAL_WINNER + Constants.COLON_SPACES + winnersName.joinToString(Constants.WINNERS_NAME_SEPERATOR))
}


class Cars(carName: String) {
    var position = Constants.START_POSITION
    val name = carName

    fun move() {
        if (Randoms.pickNumberInRange(Constants.RANDOM_NUMBER_START, Constants.RANDOM_NUMBER_END) >= Constants.MOVING_CONDITION) {
            position++
        }
    }
}