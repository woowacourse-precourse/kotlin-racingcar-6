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

    enum class UserNameValidation(val message: String) {
        OVER_LENGTH("이름은 ${LIMIT_USERNAME}자 이하로 입력해주세요."), LEAST_ONE("한 명 이상 입력해주세요."), VALID("유효한 입력입니다.")
    }
}