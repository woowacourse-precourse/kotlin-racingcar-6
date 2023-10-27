package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun checkAvailableCarName(carName: List<String>) {
    for(name in carName) {
        if(name.length > 5)
            throw IllegalArgumentException("Car name must be at most 5 letters")
    }
}

fun splitCarName(initCarName: String): List<String> {
    return initCarName.split(",")
}

fun enterCarName(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val initCarName = Console.readLine()
    val carName = splitCarName(initCarName)

    checkAvailableCarName(carName)

    return carName
}

fun enterTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")

    val tryCount = Console.readLine().toInt()

    return tryCount
}
fun main() {
    enterCarName()
    enterTryCount()
}
