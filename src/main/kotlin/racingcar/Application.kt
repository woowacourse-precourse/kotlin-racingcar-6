package racingcar

import camp.nextstep.edu.missionutils.Console

private const val CAR_NAME_MAX_LENGTH = 5
private const val RACE_START_MSG = "경주할 자동차 이름을 입력하세요."
private const val NUMBER_ATTEMPTS_MSG = "시도할 횟수는 몇 회인가요?"
const val BASE_NUMBER = 4

private const val NUMBER_ATTEMPTS_REGEX = "[1-9]+"

fun main() {

    println(RACE_START_MSG)
    val carNames = getCarList()

    if (!isCarNameUnique(carNames)) throw IllegalArgumentException("Duplicate car names are not allowed.")
    carNames.forEach { name ->
        if (!isCarNameNotEmpty(name)) throw IllegalArgumentException("Car name cannot be empty.")
        if (!isCarNameLengthValid(name)) throw IllegalArgumentException("Car name '$name' exceeds the maximum allowed length of $CAR_NAME_MAX_LENGTH.")
    }

    println(NUMBER_ATTEMPTS_MSG)

    val numberAttempts = getNumberAttempts()
    if (!isNumberAttemptsValid(numberAttempts)) throw IllegalArgumentException("Invalid format for number of attempts. Please use the specified format.")


    val cars: List<Car> = carNames.indices.map { Car(name = "", distance = 0) }
    carNames.forEachIndexed { idx, name -> cars[idx].name = name }

    val racing = Racing(cars)
    racing.getRacingDistances(numberAttempts.toInt())
}

fun getCarList() = Console.readLine().split(",")
fun isCarNameUnique(carList: List<String>) = carList.size == carList.toSet().size
fun isCarNameLengthValid(carName: String) = carName.length <= CAR_NAME_MAX_LENGTH
fun isCarNameNotEmpty(carName: String) = carName.trim().isNotEmpty()

fun getNumberAttempts(): String = Console.readLine().trim()
fun isNumberAttemptsValid(numberAttempts: String) = NUMBER_ATTEMPTS_REGEX.toRegex().matches(numberAttempts)

