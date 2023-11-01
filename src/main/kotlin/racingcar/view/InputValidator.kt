package racingcar.view

import java.util.regex.Pattern

class InputValidator {
    fun validateCarNamesInput(input: String) {
        if (!Pattern.matches(CAR_NAMES_REGEX, input)) {
            throw IllegalArgumentException("유효하지 않은 입력입니다. 차 이름은 ,로 구분해주세요.")
        }
    }

    fun validateMaxRound(input: String) {
        if (!Pattern.matches(MAX_ROUND_REGEX, input)) {
            throw IllegalArgumentException("유효하지 않은 입력입니다. 숫자를 입력해주세요.")
        }
    }

    companion object {
        private const val CAR_NAMES_REGEX = "^(\\w+,)+\\w+$"
        private const val MAX_ROUND_REGEX = "^\\d+$"
    }
}