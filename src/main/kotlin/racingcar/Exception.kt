package racingcar

class Exception {
    fun nameValidation(name: List<String>) {
        name.forEach {
            if (it.length > 5) throw IllegalArgumentException(NAME_LENGTH_EXCEPTION)
            if (it.isEmpty()) throw IllegalArgumentException(EMPTY_NAME_EXCEPTION)
        }
    }

    fun roundsValidation(input: String): Int {
        val count = input.toIntOrNull() ?: throw IllegalArgumentException(NOT_NUMBER_EXCEPTION)
        if (count < 0) throw IllegalArgumentException(NEGATIVE_INTEGER_EXCEPTION)
        return count
    }

    companion object {
        const val NAME_LENGTH_EXCEPTION = "5글자를 초과할 수 없습니다."
        const val EMPTY_NAME_EXCEPTION = "이름이 비어있습니다."
        const val NOT_NUMBER_EXCEPTION = "숫자가 아닙니다."
        const val NEGATIVE_INTEGER_EXCEPTION = "0보다 작은 수는 입력할 수 없습니다."
    }
}