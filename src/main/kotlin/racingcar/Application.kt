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

    val numberOfTrial = validateTrialNumber(trial)

    println(ConstValue.RESULT)

}

private fun makeCarList(carList: String): List<String> {
    if (carList.isEmpty()) {
        throw IllegalArgumentException("입력값이 없습니다.")
    } else {
        return carList.split(",")
    }
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



