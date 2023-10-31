package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carInput = Console.readLine()
    val carList = carInput.split(",")
    processExceptionCar(carInput, carList)

    val playCount= Console.readLine()
    processExceptionCount(playCount)

    val resList = MutableList(carList.size) {0}
    var count = playCount.toInt()

    while (count != 0) {
        val locationList = movingCar(resList)
        for (i in 0..<locationList.size) {
            println(String.format("%s : %s", carList[i], locationList[i]))
        }
        count--
        println()
    }

    val maxRes = resList.max()
    val winners = mutableListOf<String>()
    for ((index, value) in resList.withIndex()) {
        if (value == maxRes) {
            winners.add(carList[index])
        }
    }
    print("최종 우승자 : ")
    println(winners.joinToString(", "))
}

fun processExceptionCar(carInput: String, carList: List<String>) {
    if (carInput.isNullOrBlank()) {
        throw IllegalArgumentException(Const.EXCEPTION_WRONG_INPUT)
    }
    for (name in carList) {
        if (name.toList().any { !it.isLetterOrDigit() }) {
            throw IllegalArgumentException(Const.EXCEPTION_WRONG_NAME)
        }

        if (name.length > 5) {
            throw  IllegalArgumentException(Const.EXCEPTION_NAME_LENGTH)
        }
    }
}

fun processExceptionCount(playCount: String) {
    if (playCount.isNullOrBlank() || playCount == "0") {
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