package racingcar

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputCarName(): List<String> {
        val carNameList = Console.readLine().split(",")
        return checkCarNameList(carNameList)
    }

    fun checkCarNameList(carNameList: List<String>): List<String> {
        require(carNameList.isNotEmpty()) { "이름을 입력해야합니다." }
        for (carName in carNameList) {
            require (carName.length <= 5) { "이름은 5글자 이하만 가능합니다." }
            require (carName.isNotEmpty()) { "이름이 제대로 입력되지 않았습니다." }
            require(carName[0] != ' ') { "이름의 첫글자가 공백입니다." }
        }
        return carNameList
    }

    fun inputRoundNumber(): Int {
        val roundNumber = Console.readLine()
        return checkRoundNumber(roundNumber)
    }

    fun checkRoundNumber(roundNumber: String): Int {
        try {
            val validRoundNumber = roundNumber.toInt()
            require(validRoundNumber >= 1) { "시도할 횟수는 1보다 커야합니다." }
            return validRoundNumber
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException("시도할 횟수는 숫자여야 합니다.")
        }
    }

    fun closeConsole() {
        Console.close()
    }
}