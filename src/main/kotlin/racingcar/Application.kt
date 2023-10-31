package racingcar

import camp.nextstep.edu.missionutils.Console

private const val NOT_INT_OR_NULL = "숫자가 아니거나 null입니다."
private const val INPUT_UNDER_ZERO = "입력 값에 음수가 있습니다."
private const val INPUT_OVER_FIVE_OR_NULL = "이름이 5자가 넘어가거나 값이 없습니다."
private const val INPUT_HAVE_SPACE = ",뒤에 공백이 있습니다."
private const val INPUT_DUPLICATE = "중복된 수가 있습니다."
private const val INPUT_SIZE = "2대 이상 입력해야 합니다."
private const val SPACE = " "
private const val MAX_LENGTH = 5
private const val INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
private const val INPUT_REPEAT = "시도할 횟수는 몇 회인가요?"
private var cars = mutableListOf<Car>()
fun main() {
    println(INPUT_NAME)
    input()
    processGame(inputRepeat())
    winner()
}
private fun input() {
    val carname = Console.readLine()
    val names = carname.split(',')
    checkName(names)
    for (name in names) {
        cars.add(Car(name))
    }
}

private fun processGame(repeat: Int) {
    println()
    println("실행 결과")
    var rep = repeat
    while (rep > 0) {
        for (car in cars) {
            car.play()
        }
        println()
        rep--
    }
}

private fun inputRepeat(): Int {
    println(INPUT_REPEAT)
    val repeat = Console.readLine()
    checkNum(repeat)
    Console.close()
    return repeat.toInt()
}

private fun winner() {
    val winners = mutableListOf<String>()
    val maxPosition = findMaxPos()
    for (car in cars) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName())
        }
    }
    printWinner(winners)
}

private fun findMaxPos(): Int {
    var max = 0
    for (car in cars) {
        if (car.getPosition() >= max) {
            max = car.getPosition()
        }
    }
    return max
}
private fun printWinner(winners: MutableList<String>) {
    print("최종 우승자 : ${winners.joinToString(", ")}")
}
fun checkNum(repeat: String) {
    if (repeat.toIntOrNull() == null) {
        throw IllegalArgumentException(NOT_INT_OR_NULL)
    }
    checkNumMinus(repeat)
}

private fun checkNumMinus(repeat: String) {
    if (repeat.toInt() < 1) {
        throw IllegalArgumentException(INPUT_UNDER_ZERO)
    }
}

fun checkName(cars: List<String>) {
    for (i in cars.indices) {
        checkError(cars[i])
        checkSpace(cars[i])
    }
    checkDuplicate(cars)
    checkSize(cars)
}

private fun checkError(input: String) {
    if (input.length > MAX_LENGTH || input.isEmpty()) {
        throw IllegalArgumentException(INPUT_OVER_FIVE_OR_NULL)
    }
}

private fun checkSpace(input: String) {
    if (input.contains(SPACE)) {
        throw IllegalArgumentException(INPUT_HAVE_SPACE)
    }
}

private fun checkDuplicate(input: List<String>) {
    if (input.toSet().size != input.size) {
        throw IllegalArgumentException(INPUT_DUPLICATE)
    }
}

private fun checkSize(input: List<String>) {
    if (input.size < 2) {
        throw IllegalArgumentException(INPUT_SIZE)
    }
}