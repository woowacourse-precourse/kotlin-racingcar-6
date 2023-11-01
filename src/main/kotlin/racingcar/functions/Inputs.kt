package racingcar.functions

import camp.nextstep.edu.missionutils.Console
import racingcar.Cars
import racingcar.Constants

fun carNamesInput(): List<Cars> {
    println(Constants.CAR_NAME_INPUT_MESSAGE)
    val carNames = Console.readLine()
    val cars = carNames.split(Constants.CAR_NAMES_SPLITER).map { Cars(it) }
    validateCarNames(cars)
    return cars
}

fun roundInput(): Int {
    println(Constants.ROUND_INPUT)
    val raceRound = Console.readLine().toInt()
    validateRaceRound(raceRound)
    return raceRound
}

fun startInputs(): Pair<List<Cars>, Int> {
    val cars = carNamesInput()
    val raceRound = roundInput()
    return Pair(cars, raceRound)
}