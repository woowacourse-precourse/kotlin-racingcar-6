package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val nameList = askCarNames()
    val moveCars = MoveCars(nameList, askNumber())
    val numList = moveCars.repeatTryNumber()
    Winner(nameList, numList).whoWinner()
}

fun askCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carList = Console.readLine().split(",")
    if (carList.any { it == "" || it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 1~5자로 작성해주세요")
    }
    return carList
}

fun askNumber(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val tryNumber = try {
        val num = Console.readLine().toInt()
        require(num >= 1) { "1 이상 숫자만 입력해 주세요" }
        num
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("1 이상 숫자만 입력해 주세요")
    }
    return tryNumber
}

