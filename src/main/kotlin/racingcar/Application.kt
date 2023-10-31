package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.Constants.NUMBER_ATTEMPTS_MSG
import racingcar.Constants.RACE_START_MSG
import racingcar.Validator.isCarNameLengthValid
import racingcar.Validator.isCarNameNotEmpty
import racingcar.Validator.isCarNameUnique
import racingcar.Validator.isNumberAttemptsValid

private lateinit var cars: List<Car>
private lateinit var numberAttempts: String
fun main() {
    printRaceStart(RACE_START_MSG).run {
        val carNames = getValidCarList()
        cars = initializeCars(carNames)
    }

    printNumberAttempts(NUMBER_ATTEMPTS_MSG).run {
        numberAttempts = getNumberAttempts()
        isNumberAttemptsValid(numberAttempts)
    }

    val racing = Racing()
    racing.doRacing(numberAttempts.toInt(), cars)
}

fun getValidCarList(): List<String> {
    val carNames = getCarList()
    isCarNameUnique(carNames)
    carNames.forEach { name ->
        isCarNameLengthValid(name)
        isCarNameNotEmpty(name)
    }
    return carNames
}
fun getCarList() = Console.readLine().split(",")
fun getNumberAttempts(): String = Console.readLine().trim()
fun initializeCars(carNames: List<String>): List<Car> {
    val cars: List<Car> = carNames.indices.map { Car(name = "", distance = 0) }
    carNames.forEachIndexed { idx, name -> cars[idx].name = name }
    return cars
}
fun printRaceStart(raceStartMsg: String) {
    println(raceStartMsg)
}
fun printNumberAttempts(numberAttemptsMsg: String) {
    println(numberAttemptsMsg)
}