package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    askCarNames()
}

fun askCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carList = Console.readLine().split(",")
    if (carList.any { it == "" || it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 1~5자로 작성해주세요")
    }
    return carList
}



