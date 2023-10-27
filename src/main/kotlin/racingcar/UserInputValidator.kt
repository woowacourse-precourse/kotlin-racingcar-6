package racingcar

class UserInputValidator {
    companion object {
        const val USER_NAME_INPUT_EXCEPTION_MESSAGE = "입력하신 이름 중 5자가 초과하는 이름이 있어, 잘못된 입력입니다."
        const val USER_TRY_COUNT_INPUT_EXCEPTION_MESSAGE = "입력한 문자열이 숫자가 아닙니다."
    }

    fun userNameInputValidator(nameList: MutableList<String>) {
        for(name in nameList) {
            if (name.length > 5) throw IllegalArgumentException(USER_NAME_INPUT_EXCEPTION_MESSAGE)
        }
    }

    fun userTryCountInputValidator(input: String) {
        when {
            input.toIntOrNull() == null -> throw IllegalArgumentException(USER_TRY_COUNT_INPUT_EXCEPTION_MESSAGE)
        }
    }
}