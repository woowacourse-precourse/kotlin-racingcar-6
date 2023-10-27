package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun checkExceptionCarName(carName: List<String>) {
    for(name in carName) {
        if(name.length > 5) {
            throw IllegalArgumentException("Car name must be at most 5 letters")
        }
    }
}

fun checkExceptionTryCount(tryCount: Int) {
    if(tryCount <= 0) {
        throw IllegalArgumentException("Count must be natural number")
    }
}

fun splitCarName(initCarName: String): List<String> {
    return initCarName.split(",")
}

fun getCarName(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val initCarName = Console.readLine()
    val carName = splitCarName(initCarName)

    checkExceptionCarName(carName)

    return carName
}

fun getTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")

    val tryCount = Console.readLine().toInt()

    checkExceptionTryCount(tryCount)

    return tryCount
}

fun initCarForwardCount(carForwardCount: MutableList<Int>, tryCount: Int) {
    for(i in 1..tryCount)
        carForwardCount.add(0)
}

fun saveForwardCountEachCar(carForwardCount: MutableList<Int>, carCount: Int, randomNum: Int) {
    if(randomNum>=4) {
        carForwardCount[carCount]++
    }
}

fun saveForwardCountEachGame(carForwardCount: MutableList<Int>) {
    for(carCount in carForwardCount.indices) {
        val randomNum = Randoms.pickNumberInRange(0,9)

        saveForwardCountEachCar(carForwardCount, carCount, randomNum)
    }
}

fun printProgress(carName: List<String>, carForwardCount: MutableList<Int>) {
    for( i in carName.indices ) {
        print("${carName[i]} : ")
        printProgressForwardCount(carForwardCount[i])
    }
    println("")
}

fun printProgressForwardCount(forwardCount: Int) {
    for(i in 1..forwardCount) {
        print("-")
    }
    println("")
}

fun playGame(carName: List<String>, tryCount: Int) {
    //자동차 별 전진 횟수 저장
    val carForwardCount = mutableListOf<Int>()

    initCarForwardCount(carForwardCount,carName.size)

    printRunningResult(carName, carForwardCount, tryCount)

    printVictoryCar(carForwardCount,carName)
}

fun printRunningResult(carName: List<String>, carForwardCount: MutableList<Int>, tryCount: Int) {

    println("")
    println("실행 결과")

    for(gameCount in 0..(tryCount-1)) {
        saveForwardCountEachGame(carForwardCount)
        printProgress(carName, carForwardCount)
    }
}

fun printVictoryCar(carForwardCount: MutableList<Int>, carName: List<String>) {
    val finalVictoryCar = mutableListOf<String>()

    checkFinalVictoryCar(finalVictoryCar, carForwardCount, carName)
    printFinalVictoryCarWithSeparator(finalVictoryCar)
}

fun checkFinalVictoryCar(finalVictoryCar: MutableList<String>, carForwardCount: MutableList<Int>, carName: List<String>) {
    for(i in carForwardCount.indices) {
        if(carForwardCount.max() == carForwardCount[i]) {
            finalVictoryCar.add(carName[i])
        }
    }
}

fun printFinalVictoryCarWithSeparator(finalVictoryCar: MutableList<String>) {
    print("최종 우승자 : ")
    print(finalVictoryCar.joinToString(separator = ", "))
}

fun main() {
    playGame(getCarName(),getTryCount())
}
