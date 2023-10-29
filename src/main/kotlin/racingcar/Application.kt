package racingcar

import camp.nextstep.edu.missionutils.Console

private const val CAR_NAME_MAX_LENGTH = 5
private const val RACE_START_MSG = "경주할 자동차 이름을 입력하세요."
private const val NUMBER_ATTEMPTS_MSG = "시도할 횟수는 몇 회인가요?"
const val BASE_NUMBER = 4


fun main() {

    println(RACE_START_MSG)
    val carNames = getCarList()
    isCarNameUnique(carNames)
    carNames.forEach { name ->
        isCarNameLengthValid(name)
        isCarNameNotEmpty(name)
    }

    println(NUMBER_ATTEMPTS_MSG)

    val numberAttempts = getNumberAttempts()
    isNumberAttemptsValid(numberAttempts)


    val cars: List<Car> = carNames.indices.map { Car(name = "", distance = 0) }
    carNames.forEachIndexed { idx, name -> cars[idx].name = name }

    val racing = Racing(cars)
    racing.getRacingDistances(numberAttempts.toInt())
}

fun getCarList() = Console.readLine().split(",")
fun isCarNameUnique(carList: List<String>) {
    if (carList.size != carList.toSet().size) throw IllegalArgumentException("Duplicate car names are not allowed.")
}

fun isCarNameLengthValid(carName: String) {
    if (carName.length > CAR_NAME_MAX_LENGTH) throw IllegalArgumentException("Car name cannot be empty.")
}

fun isCarNameNotEmpty(carName: String) {
    if (carName.trim().isEmpty()) throw  IllegalArgumentException("Car name '$carName' exceeds the maximum allowed length of $CAR_NAME_MAX_LENGTH.")
}

fun getNumberAttempts(): String = Console.readLine().trim()

fun isNumberAttemptsValid(numberAttempts: String) {
    if(! (numberAttempts.all { it.isDigit() }) || numberAttempts.toInt() < 1) throw  IllegalArgumentException("Invalid format for number of attempts. Please use the specified format.")
}


