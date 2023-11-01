package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGame(Console::readLine, Randoms::pickNumberInRange)
}

fun startGame(readLine: () -> String, pickNumberInRange: (Int, Int) -> Int) {
    val carList = inputCarName(readLine)
    val tryNumber = inputTryNumber(readLine)

    printRacing(carList, tryNumber, pickNumberInRange)

    val winnerNameList = decideWinnerNameList(carList)
    printWinner(winnerNameList)
}

fun inputCarName(readLine: () -> String): List<Car> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return readLine().split(",").map { Car(it.trim()) }
}

fun inputTryNumber(readLine: () -> String): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readLine().apply {
        require(this.isNotEmpty() && Regex("[0-9]+").matches(this)) { "시도할 횟수는 숫자만 입력해야만 합니다." }
    }.toInt()
}

fun printRacing(carList: List<Car>, tryNumber: Int, pickNumberInRange: (Int, Int) -> Int) {
    println("\n실행 결과")

    for (round in 0 until tryNumber) {
        raceCar(carList, pickNumberInRange)
        printCurrentRace(carList)
    }
}

fun raceCar(carList: List<Car>, pickNumberInRange: (Int, Int) -> Int) {
    for (car in carList) {
        val randomNumber = pickNumberInRange(0, 9)
        driveCar(car, randomNumber)
    }
}

fun driveCar(car: Car, randomNumber: Int) {
    if (randomNumber >= 4) {
        car.drive()
    }
}

fun printCurrentRace(carList: List<Car>) {
    for (car in carList) {
        println("${car.name} : ${car.distance}")
    }
    println()
}

fun decideWinnerNameList(carList: List<Car>): List<String> {
    val max = carList.maxOf { it.distanceLength }
    return carList.filter { it.distanceLength == max }.map { it.name }
}

fun printWinner(winnerList: List<String>) {
    print("최종 우승자 : ${winnerList.joinToString(", ")}")
}