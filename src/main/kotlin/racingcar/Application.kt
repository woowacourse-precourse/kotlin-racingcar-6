package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    playGame()
}

private fun playGame() {
    println(ConstValue.FIRST_LINE)
    val carString = Console.readLine().toString()

    val carList = makeCarList(carString)

    val finalCarList = validateCarNameLength(carList)

    println(ConstValue.SECOND_LINE)
    val trial = Console.readLine().toString()

    var numberOfTrial = validateTrialNumber(trial)

    println(ConstValue.RESULT)

    val map = makeCarMap(finalCarList)

    do {
        doSaveCarMove(finalCarList, map)
        numberOfTrial -= 1
        println()
    } while (numberOfTrial != 0)

    showWinner(map)

}

private fun validateCarNameLength(carList: List<String>): List<String> {
    for (car in carList) {
        if (car.length > 5) {
            throw IllegalArgumentException(ConstValue.ERROR_CAR_NAME_OUT_OF_RANGE)
        }
    }
    return carList.filter { it.length < 5 }
}

private fun makeCarList(carList: String): List<String> {
    if (carList.isEmpty()) {
        throw IllegalArgumentException(ConstValue.ERROR_NO_INPUT)
    } else {
        return carList.split(",")
    }
}

private fun makeCarMap(carList: List<String>): MutableMap<String, Int> {
    val score: MutableMap<String, Int> = mutableMapOf()
    for (car in carList) {
        score[car] = 0
    }
    return score
}

private fun validateTrialNumber(num: String): Int {
    if (num.isEmpty()) {
        throw IllegalArgumentException(ConstValue.ERROR_NO_INPUT)
    }
    try {
        val inputNumber = num.toInt()
        if (inputNumber <= 0) {
            throw IllegalArgumentException(ConstValue.ERROR_INPUT_BELOW_POSITIVE)
        }
        return inputNumber
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ConstValue.ERROR_INPUT_NOT_NUM)
    }
}

private fun doSaveCarMove(carList: List<String>, map: MutableMap<String, Int>) {
    //println(map)
    for (car in carList) {
        saveCarMove(car, map)
        //println(map)
    }
    showResult(carList, map)
}

private fun showResult(carList: List<String>, carMap: MutableMap<String, Int>) {
    for (car in carList) {
        print("${car} : ")
        printCarMove(car, carMap)
        println()
    }
}

private fun printCarMove(car: String, carMap: MutableMap<String, Int>) {
    var num = carMap[car]
    if (num != null) {
        while (num != 0) {
            print("-")
            num -= 1
        }
    }
}

// 4이상의 수가 나올 때만 값 저장
private fun saveCarMove(carString: String, map: MutableMap<String, Int>) {
    val randomNum = generateRandomNumber()
    //println(randomNum)
    if (randomNum >= 4) {
        map[carString] = map[carString]!! + 1
    }
}

private fun generateRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

private fun showWinner(carMap: MutableMap<String, Int>) {
    val maxValue = carMap.values.max()
    val winnerKeys: MutableList<String> = mutableListOf()
    for ((key, value) in carMap) {
        if (value == maxValue) {
            winnerKeys.add(key)
        }
    }
    val winnerName = winnerKeys.joinToString(", ")
    println("최종 우승자 : $winnerName")
}
