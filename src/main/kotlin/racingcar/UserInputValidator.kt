package racingcar

class UserInputValidator {
    companion object {
        const val USER_NAME_INPUT_LENGTH_EXCEPTION_MESSAGE = "입력하신 이름 중 5자가 초과하는 이름이 있어, 잘못된 입력입니다."
        const val USER_NAME_INPUT_NAME_DUPLICATE_EXCEPTION_MESSAGE = "입력하신 이름 중 중복되는 이름이 있습니다."
        const val USER_TRY_COUNT_INPUT_IS_NOT_NUMBER_EXCEPTION_MESSAGE = "입력한 문자열이 숫자가 아닙니다."
        const val USER_TRY_COUNT_INPUT_IS_MINUS_NUMBER_EXCEPTION_MESSAGE = "시도할 횟수에는 음수가 올 수 없습니다."
        const val NAME_MAX_LENGTH = 5
    }

    fun userNameInputValidator(nameList: MutableList<String>) {
        for(name in nameList) {
            when {
                isNotCorrectLength(name) -> invokeIllegalArgumentException(USER_NAME_INPUT_LENGTH_EXCEPTION_MESSAGE)
                hasDuplicateName(name, nameList) -> invokeIllegalArgumentException(USER_NAME_INPUT_NAME_DUPLICATE_EXCEPTION_MESSAGE)
            }
        }
    }

    fun userTryCountInputValidator(input: String) {
        when {
            isNotNumber(input) -> invokeIllegalArgumentException(USER_TRY_COUNT_INPUT_IS_NOT_NUMBER_EXCEPTION_MESSAGE)
            input.toInt() < 0 -> invokeIllegalArgumentException(USER_TRY_COUNT_INPUT_IS_MINUS_NUMBER_EXCEPTION_MESSAGE)
        }
    }

    private fun isNotCorrectLength(name: String) = name.length > NAME_MAX_LENGTH
    private fun isNotNumber(str: String) = str.toIntOrNull() == null


    private fun hasDuplicateName(target: String, nameList: MutableList<String>): Boolean {
        var count = 0
        for(name in nameList) {
            if(name == target) {
                count += 1
            }
        }
        return count > 1
    }

    private fun invokeIllegalArgumentException(message: String) {
        throw IllegalArgumentException(message)
    }
}