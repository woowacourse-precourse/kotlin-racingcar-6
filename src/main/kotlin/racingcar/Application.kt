package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    gameStart()
}

fun gameStart() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputNames = Console.readLine()
    val listOfCarName = checkValidName(inputNames)

    println("시도할 횟수는 몇 회인가요?")
    val inputCount = Console.readLine()
    val counOfTrial = checkValidNumber(inputCount)
}

fun checkValidName(stringOfNames: String): List<String> {
    val listOfCarName = stringOfNames.split(",")
    for (name in listOfCarName) {
        if (name.length > 5)
            throw IllegalArgumentException("5자 이상인 이름 입력 발생")
    }
    return listOfCarName
}

fun checkValidNumber(countString: String): Int {
    if (countString.toIntOrNull() == null) {
        throw IllegalArgumentException("숫자가 아닌 횟수 입력 발생")
    }
    return countString.toInt()
}