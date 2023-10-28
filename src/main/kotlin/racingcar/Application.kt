package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val listOfCar = Console.readLine()
        .split(',')

    println("시도할 횟수는 몇 회인가요?")
    var round = getUserIntInput()
}
fun getUserIntInput(): Int {
    var input: Int
    try {
        input = Console.readLine().toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
    return input
}