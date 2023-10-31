package racingcar

import racingcar.strings.Strings

object Exceptions {
    fun inputCarNameException(input: String?): List<String> {

        if (input == null) {
            throw IllegalArgumentException(Strings.EXCEPTION_NULL)
        } else {
            val carNames = input.split(",").map { it.trim() }

            when {
                carNames.any { it.isBlank() } -> {
                    throw IllegalArgumentException(Strings.EXCEPTION_IS_BLANK)
                }

                carNames.size < 2 -> {
                    throw IllegalArgumentException(Strings.EXCEPTION_MINIMUM_SIZE)
                }

                carNames.all { it.length <= 5 } -> {
                    return carNames
                }

                else -> {
                    throw IllegalArgumentException(Strings.EXCEPTION_MAX_INPUT)
                }
            }
        }
    }

    fun inputTryCountException(input: String?): Int {
        if (input != null && input.all { it.isDigit() } && input.toInt() != 0) {
            val tryCountInt = input.toInt()
            if (tryCountInt > 0) {
                return tryCountInt
            }
        }
        throw IllegalArgumentException("올바른 숫자를 입력해주세요.")
    }
}