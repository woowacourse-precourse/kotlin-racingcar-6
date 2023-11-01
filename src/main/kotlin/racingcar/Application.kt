package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carInput = Console.readLine()
    val carList = carInput.split(",")
    processExceptionCar(carList)

    val playCount= Console.readLine()
    processExceptionCount(playCount)

    val resList = MutableList(carList.size) {0}
    var count = playCount.toInt()

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
    println(winnerList.joinToString(", "))
}

fun processExceptionCar(carList: List<String>) {
    for (name in carList) {
        val dupliList = carList.distinct()
        if (dupliList.size != carList.size) {
            throw IllegalArgumentException(Const.EXCEPTION_DUPLI_NAME)
        }

        if (name.toList().any { !it.isLetterOrDigit() }) {
            throw IllegalArgumentException(Const.EXCEPTION_WRONG_NAME)
        }

        if (name.length > 5) {
            throw  IllegalArgumentException(Const.EXCEPTION_LENGTH_NAME)
        }
    }
}

fun processExceptionCount(playCount: String) {
    if (playCount == "0") {
        throw IllegalArgumentException(Const.EXCEPTION_WRONG_NUMBER)
    }
    if (playCount.toList().any { !it.isDigit() }) {
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