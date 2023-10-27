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

fun decideNumCount(carForwardCount: MutableList<Int>, carCount: Int, randomNum: Int) {
    if(randomNum>=4) {
        carForwardCount[carCount]++
    }
}

fun randomNumEachGame(carForwardCount: MutableList<Int>) {

    for(carCount in carForwardCount.indices) {

        val randomNum = Randoms.pickNumberInRange(0,9)

        decideNumCount(carForwardCount, carCount, randomNum)
    }
}

fun printProgress(carName: List<String>, carForwardCount: MutableList<Int>) {
    for( i in carName.indices ) {

        print("${carName[i]} : ")

        printProgressCount(carForwardCount[i])
    }
    println("")
}

fun printProgressCount(forwardCount: Int) {

    for(i in 1..forwardCount) {
        print("-")
    }
    println("")
}

fun startGame(carName: List<String>, tryCount: Int) {
    //자동차 별 전진 횟수 저장
    val carForwardCount = mutableListOf<Int>()

    initCarForwardCount(carForwardCount,carName.size)

    println("")
    println("실행 결과")
    
    for(gameCount in 0..(tryCount-1)) {
        randomNumEachGame(carForwardCount)
        printProgress(carName, carForwardCount)
    }

    val finalVictoryCar = mutableListOf<String>()

    for(i in carForwardCount.indices) {
        if(carForwardCount.max() == carForwardCount[i]) {
            finalVictoryCar.add(carName[i])
        }
    }
    printFinalVictoryCar(finalVictoryCar)
}

fun printFinalVictoryCar(finalVictoryCar: MutableList<String>) {
    print("최종 우승자 : ")
    print(finalVictoryCar.joinToString(separator = ", "))

}
fun main() {
    startGame(enterCarName(),enterTryCount())
}
