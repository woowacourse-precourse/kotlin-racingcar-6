package racingcar.util

object InputValidator {
    private const val LIMIT_USERNAME = 5
    fun validateUserName(users: List<String>): UserNameValidation {
        if (users.isEmpty()) {
            return UserNameValidation.LEAST_ONE
        }

        val isOverLength = users.any { it.length > LIMIT_USERNAME }
        if (isOverLength) {
            return UserNameValidation.OVER_LENGTH
        }

        return UserNameValidation.VALID
    }

    fun validateGameCount(input: String): GameCountValidation {
        val intValue = try {
            input.toInt()
        } catch (nfe: NumberFormatException) {
            return GameCountValidation.NOT_DIGIT
        }

        return if (intValue < 0) {
            GameCountValidation.OUT_RANGE
        } else {
            GameCountValidation.VALID
        }
    }

    enum class UserNameValidation(val message: String) {
        OVER_LENGTH("이름은 ${LIMIT_USERNAME}자 이하로 입력해주세요."),
        LEAST_ONE("한 명 이상 입력해주세요."),
        VALID("유효한 입력입니다.")
    }

    enum class GameCountValidation(val message: String) {
        NOT_DIGIT("숫자만 입력해주세요."),
        OUT_RANGE("0 이상의 수를 입력해주세요"),
        VALID("유효한 입력입니다.")
    }
}