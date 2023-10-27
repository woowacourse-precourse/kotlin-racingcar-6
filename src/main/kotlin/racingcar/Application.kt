package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun checkAvailableCarName(carName: List<String>) {
    for(name in carName) {
        if(name.length > 5) {
            throw IllegalArgumentException("Car name must be at most 5 letters")
        }
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

fun initCarForwardCount(carForwardCount: MutableList<Int>, tryCount: Int) {
    for(i in 1..tryCount)
        carForwardCount.add(0)
}

fun randomNumEachCar(carForwardCount: MutableList<Int>, gameCount: Int) {
    val randomNum = Randoms.pickNumberInRange(0,9)
}

fun startGame(carName: List<String>, tryCount: Int) {
    //자동차 별 전진 횟수 저장
    val carForwardCount = mutableListOf<Int>()

    initCarForwardCount(carForwardCount,carName.size)

    for(gameCount in 0..(tryCount-1)) {
        randomNumEachCar(carForwardCount,gameCount)
    }
    println(carForwardCount)
}

fun main() {
    startGame(enterCarName(),enterTryCount())
}
