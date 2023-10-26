package racingcar.iomanager

import camp.nextstep.edu.missionutils.Console.readLine


class InputManager() {
    fun carNames(): List<String> = getValidCarNames(readLine()).toCarNamesList()

    private fun getValidCarNames(userInput: String): String {
        return userInput.trim().let { input ->
            isEmptyString(input)
            isStartAndEndWithComma(input)
            isLengthFive(input)
            userInput
        }
    }

    private fun isEmptyString(userInput: String): Boolean {
        return if (userInput != EMPTY_STRING) true else throw IllegalArgumentException()
    }

    private fun isStartAndEndWithComma(carName: String): Boolean {
        val isCheckStartEndWithComma = carName.startsWith(",") || carName.endsWith(",")
        return if (!isCheckStartEndWithComma) true else throw IllegalArgumentException()
    }

    private fun isLengthFive(carName: String): Boolean {
        carName.toCarNamesList().forEach { if (it.length >= CAR_NAME_SIZE) throw IllegalArgumentException() }
        return true
    }

    private fun String.toCarNamesList(): List<String> = split(",").map { it.trim() }

    companion object {
        private const val CAR_NAME_SIZE = 5
        private const val EMPTY_STRING = ""
    }
}