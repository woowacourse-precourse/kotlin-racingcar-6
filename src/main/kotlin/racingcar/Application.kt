package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.Constants.CAR_NAME_MAX_LENGTH
import racingcar.Constants.NUMBER_ATTEMPTS_MSG
import racingcar.Constants.RACE_START_MSG

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
    racing.getRacingDistances(numberAttempts.toInt(), cars)
}

fun getCarList() = Console.readLine().split(",")
fun isCarNameUnique(carList: List<String>) {
    if (carList.size != carList.toSet().size) throw IllegalArgumentException("Duplicate car names are not allowed.")
}

fun isCarNameLengthValid(carName: String) {
    if (carName.length > CAR_NAME_MAX_LENGTH) throw IllegalArgumentException("Car name cannot be empty.")
}

fun isCarNameNotEmpty(carName: String) {
    if (carName.trim()
            .isEmpty()
    ) throw IllegalArgumentException("Car name '$carName' exceeds the maximum allowed length of $CAR_NAME_MAX_LENGTH.")
}

fun getNumberAttempts(): String = Console.readLine().trim()

fun isNumberAttemptsValid(numberAttempts: String) {
    if (!(numberAttempts.all { it.isDigit() }) || numberAttempts.toInt() < 1) throw IllegalArgumentException("Invalid format for number of attempts. Please use the specified format.")
}

fun printRaceStart(raceStartMsg: String) {
    println(raceStartMsg)
}

fun printNumberAttempts(numberAttemptsMsg: String) {
    println(numberAttemptsMsg)
}


