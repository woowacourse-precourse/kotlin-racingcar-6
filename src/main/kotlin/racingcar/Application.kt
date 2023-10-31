package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startGame()
}

fun startGame() {
    val carList = inputCarName()
    val tryNumber = inputTryNumber()

    printRacing(carList, tryNumber)

    val winnerNameList = decideWinnerNameList(carList)
    printWinner(winnerNameList)
}

fun inputCarName(): List<Car> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return with(Console.readLine().split(",")) {
        this.map { Car(it) }
    }
}

fun inputTryNumber(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine().apply {
        require(this.isNotEmpty() && Regex("[0-9]+").matches(this)) { "시도할 횟수는 숫자만 입력해야만 합니다." }
    }.toInt()
}

fun printRacing(carList: List<Car>, tryNumber: Int) {
    println("\n실행 결과")

    for (round in 0 until tryNumber) {
        raceCar(carList)
        printCurrentRace(carList)
    }
}

fun raceCar(carList: List<Car>) {
    for (car in carList) {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            car.drive()
        }
    }
}

fun printCurrentRace(carList: List<Car>) {
    for (car in carList) {
        println("${car.getName()} : ${car.getDistance()}")
    }
    println()
}

fun decideWinnerNameList(carList: List<Car>): List<String> {
    val max = carList.maxOf { it.getDistanceLength() }
    return carList.filter { it.getDistanceLength() == max }.map { it.getName() }
}

fun printWinner(winnerList: List<String>) {
    print("최종 우승자 : ${winnerList.joinToString(", ")}")
}