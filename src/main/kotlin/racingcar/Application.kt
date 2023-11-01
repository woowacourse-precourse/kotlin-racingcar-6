package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    inputFirstSetting()
}

private fun inputFirstSetting() {
    println(ConstValue.FIRST_LINE)
    val carString = Console.readLine().toString()

    val carList = makeCarList(carString)

    println(ConstValue.SECOND_LINE)
    val trial = Console.readLine().toString()

    var numberOfTrial = validateTrialNumber(trial)

    println(ConstValue.RESULT)

    val map = makeCarMap(carList)

    do {
        doSaveCarMove(carList, map)
        numberOfTrial -= 1
        println()
    } while (numberOfTrial != 0)

}

private fun makeCarList(carList: String): List<String> {
    if (carList.isEmpty()) {
        throw IllegalArgumentException("입력값이 없습니다.")
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
        throw IllegalArgumentException("입력값이 없습니다.")
    }
    try {
        val inputNumber = num.toInt()
        if (inputNumber <= 0) {
            throw IllegalArgumentException("입력값이 0 이하입니다")
        }
        return inputNumber
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("입력값이 숫자가 아닙니다")
    }
}

private fun doSaveCarMove(carList: List<String>, map: MutableMap<String, Int>) {
    //println(map)
    for (car in carList) {
        saveCarMove(car, map)
        //println(map)
    }
    //showResult(carList, map)
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

