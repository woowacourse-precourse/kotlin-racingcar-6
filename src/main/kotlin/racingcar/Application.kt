package racingcar

import camp.nextstep.edu.missionutils.Console

private const val CAR_NAME_MAX_LENGTH = 5
fun main() {
    val cars = getCarList()

    if (!isCarNameUnique(cars)) throw IllegalArgumentException("Duplicate car names are not allowed.")
    cars.forEach { car ->
        if (!isCarNameNotEmpty(car)) throw IllegalArgumentException("Car name cannot be empty.")
        if (!isCarNameLengthValid(car)) throw IllegalArgumentException("Car name '$car' exceeds the maximum allowed length of $CAR_NAME_MAX_LENGTH.")
    }
}

fun getCarList() = Console.readLine().split(",")
fun isCarNameUnique(carList: List<String>): Boolean = carList.size == carList.toSet().size
fun isCarNameLengthValid(carName: String): Boolean = carName.length <= CAR_NAME_MAX_LENGTH
fun isCarNameNotEmpty(carName: String): Boolean = carName.trim().isNotEmpty()
