package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.max

fun main() {
    startGame()
}

fun startGame() {
    val inputList = getInputList()
    val executionNum = getExecutionNum()

    val carList = mutableListOf<Car>()

    for (str in inputList) {
        carList.add(Car(str))
    }

    for (i in 0 until executionNum) {
        makeOneRound(carList)
    }

    announceWinners(decideWinners(carList))
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

fun announceWinners(winners: List<String>) {
    print("최종 우승자 : " + winners.joinToString(", "))
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

fun getExecutionNum(): Int {
    val inputStr = Console.readLine()
    requireNotNull(inputStr)
    try {
        return inputStr.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

fun getInputList(): List<String> {
    val inputStr = Console.readLine()
    requireNotNull(inputStr)
    val inputList = inputStr.split(',').toList()
    check(isNamein5Letters(inputList)) { throw IllegalArgumentException() }
    return inputList
}

fun generate0to9(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

class Car(name: String) {
    val name: String = name
    var num: Int = 0

    fun goOrStay() {
        val randomNum = generate0to9()
        if (randomNum >= 4) {
            this.num += 1
        }
    }

    private fun getStatus(): Int {
        return this.num
    }

    fun print() {
        print(name + " : " + "-".repeat(getStatus()))
    }
}
