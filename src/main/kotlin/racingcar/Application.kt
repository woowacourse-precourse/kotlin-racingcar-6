package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.Constants.NUMBER_ATTEMPTS_MSG
import racingcar.Constants.RACE_START_MSG
import racingcar.Validator.isCarNameLengthValid
import racingcar.Validator.isCarNameNotEmpty
import racingcar.Validator.isCarNameUnique
import racingcar.Validator.isNumberAttemptsValid

fun main() {

    printRaceStart(RACE_START_MSG)
    val carNames = getCarList()
    isCarNameUnique(carNames)
    carNames.forEach { name ->
        isCarNameLengthValid(name)
        isCarNameNotEmpty(name)
    }

    printNumberAttempts(NUMBER_ATTEMPTS_MSG)

    val numberAttempts = getNumberAttempts()
    isNumberAttemptsValid(numberAttempts)


    val cars: List<Car> = carNames.indices.map { Car(name = "", distance = 0) }
    carNames.forEachIndexed { idx, name -> cars[idx].name = name }

    val racing = Racing()
    racing.doRacing(numberAttempts.toInt(), cars)
}

fun getCarList() = Console.readLine().split(",")

fun getNumberAttempts(): String = Console.readLine().trim()

fun printRaceStart(raceStartMsg: String) {
    println(raceStartMsg)
}

fun printNumberAttempts(numberAttemptsMsg: String) {
    println(numberAttemptsMsg)
}


