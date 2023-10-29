package racingcar

import camp.nextstep.edu.missionutils.Console

private const val CAR_NAME_MAX_LENGTH = 5
private const val RACE_START_MSG = "경주할 자동차 이름을 입력하세요."
private const val  NUMBER_ATTEMPTS_REGEX = "[1-9]"
fun main() {
    println(RACE_START_MSG)
    /*
    val cars = getCarList()

    if (!isCarNameUnique(cars)) throw IllegalArgumentException("Duplicate car names are not allowed.")
    cars.forEach { car ->
        if (!isCarNameNotEmpty(car)) throw IllegalArgumentException("Car name cannot be empty.")
        if (!isCarNameLengthValid(car)) throw IllegalArgumentException("Car name '$car' exceeds the maximum allowed length of $CAR_NAME_MAX_LENGTH.")
    }
     */
    val numberAttempts = getNumberAttempts()

}

fun getCarList() = Console.readLine().split(",")
fun isCarNameUnique(carList: List<String>) = carList.size == carList.toSet().size
fun isCarNameLengthValid(carName: String) = carName.length <= CAR_NAME_MAX_LENGTH
fun isCarNameNotEmpty(carName: String) = carName.trim().isNotEmpty()

fun getNumberAttempts(): String = Console.readLine().trim()

