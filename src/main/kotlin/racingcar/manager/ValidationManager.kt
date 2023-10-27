package racingcar.manager

class ValidationManager {
    fun getValidCarNames(userInput: String): String {
        return userInput.trim().let { input ->
            isEmptyString(input)
            isStartAndEndWithComma(input)
            isLengthFive(input.split(",").map { it.trim() })
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

    private fun isLengthFive(carNameList: List<String>): Boolean {
        carNameList.forEach { if (it.length >= CAR_NAME_SIZE) throw IllegalArgumentException() }
        return true
    }

    fun getAttemptNumber(attemptNumber: String): Int =
        attemptNumber.toIntOrNull() ?: throw IllegalArgumentException()


    companion object {
        private const val CAR_NAME_SIZE = 5
        private const val EMPTY_STRING = ""
    }
}