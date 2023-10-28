package racingcar

class UserInputValidator {
    companion object {
        const val USER_NAME_INPUT_EXCEPTION_MESSAGE = "입력하신 이름 중 5자가 초과하는 이름이 있어, 잘못된 입력입니다."
        const val USER_TRY_COUNT_INPUT_IS_NOT_NUMBER_EXCEPTION_MESSAGE = "입력한 문자열이 숫자가 아닙니다."
        const val USER_TRY_COUNT_INPUT_IS_MINUS_NUMBER_EXCEPTION_MESSAGE = "시도할 횟수에는 음수가 올 수 없습니다."
    }

    fun userNameInputValidator(nameList: MutableList<String>) {
        for(name in nameList) {
            when {
                name.length > 5 -> invokeIllegalArgumentException(USER_NAME_INPUT_EXCEPTION_MESSAGE)
            }
        }
    }

    fun userTryCountInputValidator(input: String) {
        when {
            input.toIntOrNull() == null -> invokeIllegalArgumentException(USER_TRY_COUNT_INPUT_IS_NOT_NUMBER_EXCEPTION_MESSAGE)
            input.toInt() < 0 -> invokeIllegalArgumentException(USER_TRY_COUNT_INPUT_IS_MINUS_NUMBER_EXCEPTION_MESSAGE)
        }
    }

    private fun invokeIllegalArgumentException(message: String) {
        throw IllegalArgumentException(message)
    }
}