package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    doGame()
}

fun doGame() {
    val inputList = getInputList(getUserInput())
    val executionNum = getExecutionNum(getUserInput())

    val carList = mutableListOf<Car>()

    for (str in inputList) {
        carList.add(Car(str))
    }
    println()
    println("실행 결과")
    for (i in 0 until executionNum) {
        makeOneRound(carList)
    }

    print(announceWinners(decideWinners(carList)))
}

fun decideWinners(carList: List<Car>): List<String> {
    val winners = mutableListOf<String>()

    var maxValue = -1
    for (car in carList) {
        if (maxValue < car.num) {
            maxValue = car.num
        }
    }

    for (car in carList) {
        if (maxValue == car.num) {
            winners.add(car.name)
        }
    }
    return winners
}

fun getUserInput(): String? {
    return Console.readLine()
}

fun announceWinners(winners: List<String>): String {
    return "최종 우승자 : " + winners.joinToString(", ")
}

fun makeOneRound(carList: List<Car>) {
    for (car in carList) {
        car.goOrStay()
    }
    for (car in carList) {
        car.print()
    }
    println()
}

fun isNamein5Letters(inputList: List<String>): Boolean {
    for (str in inputList) {
        if (str.length > 5)
            return false
    }
    return true
}

fun getExecutionNum(userInput: String?): Int {
    println("시도할 횟수는 몇 회인가요?")
    requireNotNull(userInput)
    try {
        return userInput.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

fun getInputList(userInput: String?): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    requireNotNull(userInput)
    val inputList = userInput.split(',').toList()
    check(isNamein5Letters(inputList)) { throw IllegalArgumentException() }
    return inputList
}

fun generate0to9(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

class Car(name: String, num: Int) {
    val name: String = name
    var num: Int = num

    constructor(name: String) : this(name, 0) {
        this.num = num
    }


    fun goOrStay() {
        val randomNum = generate0to9()
        if (randomNum >= 4) {
            this.num += 1
        }
    }

    fun print() {
        println(name + " : " + "-".repeat(this.num))
    }
}
