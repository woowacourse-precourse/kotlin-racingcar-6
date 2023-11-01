package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println(Const.INPUT_CAR_NAME)
    val carInput = Console.readLine()
    val carList = carInput.split(",")
    processExceptionCar(carList)

    println(Const.INPUT_COUNT)
    val countInput = Console.readLine()
    processExceptionCount(countInput)

    val resList = MutableList(carList.size) {0}
    var count = countInput.toInt()

    println()
    println(Const.RESULT_MSG)
    while (count != 0) {
        val locationList = movingCar(resList)
        for (i in 0..<locationList.size) {
            println(String.format("%s : %s", carList[i], locationList[i]))
        }
        count--
        println()
    }

    val winnerList = finalWinner(carList, resList)
    print(Const.FINAL_WINNER_MSG)
    print(winnerList.joinToString(", "))
}

fun processExceptionCar(carList: List<String>) {
    for (name in carList) {
        val dupList = carList.distinct()
        if (dupList.size != carList.size) {
            throw IllegalArgumentException(Const.EXCEPTION_DUP_NAME)
        }

        if (name.toList().any { !it.isLetterOrDigit() }) {
            throw IllegalArgumentException(Const.EXCEPTION_WRONG_NAME)
        }

        if ((name.length in 1..5).not()) {
            throw  IllegalArgumentException(Const.EXCEPTION_LENGTH_NAME)
        }
    }
}

fun processExceptionCount(countInput: String) {
    if (countInput == "0") {
        throw IllegalArgumentException(Const.EXCEPTION_WRONG_NUMBER)
    }
    if (countInput.toList().any { !it.isDigit() }) {
        throw IllegalArgumentException(Const.EXCEPTION_NOT_NUMBER)
    }
}

fun movingCar(resList: MutableList<Int>): MutableList<String> {
    val resultList = mutableListOf<String>()
    for (i in 0..<resList.size) {
        val randomNum = Randoms.pickNumberInRange(0,9)
        if (randomNum >= 4) {
            resList[i] += 1
        }
        val result = "-".repeat(resList[i])
        resultList.add(result)
    }
    return resultList
}

fun finalWinner(carList: List<String>, resList: MutableList<Int>): MutableList<String> {
    val maxRes = resList.max()
    val winners = mutableListOf<String>()
    for ((index, value) in resList.withIndex()) {
        if (value == maxRes) {
            winners.add(carList[index])
        }
    }
    return winners
}