package racingcar

import camp.nextstep.edu.missionutils.Console

object InputHandler {

    fun getCarName(): List<String> {
        val inputReadLine = Console.readLine()
        if (inputReadLine.contains(" ") || inputReadLine.length > 5) {
            throw IllegalArgumentException("")
        }

        val inputData = inputReadLine.split(",")
        return if (isValidCarName(inputData)) inputData else throw IllegalArgumentException("")
    }

    fun getAmount(): Int {
        val inputData = Console.readLine().toIntOrNull()
        return if (isValidAmount(inputData)) inputData!! else throw IllegalArgumentException("")
    }

    fun isValidCarName(carNames: List<String>): Boolean = carNames.all { isAllLowerCase(it) }

    fun isValidAmount(amount: Int?): Boolean {
        amount?.let {
            if (isPositiveNumber(it)) {
                return true
            }
        }
        return false
    }

    private fun isAllLowerCase(carName: String): Boolean = carName.all { it.isLowerCase() }

    private fun isPositiveNumber(int: Int): Boolean = if (int > 0) true else false

}