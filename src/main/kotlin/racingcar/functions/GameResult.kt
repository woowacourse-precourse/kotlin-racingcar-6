package racingcar.functions

import racingcar.Cars
import racingcar.Constants

fun gameResult(cars: List<Cars>, inputRound: Int) {
    println(Constants.EXECUTION_RESULT)
    val racedCars = carRace(inputRound, cars)
    printWinners(getWinners(racedCars))
}

fun getWinners(cars: List<Cars>): List<Cars> {
    val headPosition = cars.maxOf { it.position }
    return cars.filter { it.position == headPosition }
}

fun printWinners(winners: List<Cars>) {
    val winnersName = winners.map { it.name }
    println(Constants.FINAL_WINNER + Constants.COLON_SPACES + winnersName.joinToString(Constants.WINNERS_NAME_SEPERATOR))
}