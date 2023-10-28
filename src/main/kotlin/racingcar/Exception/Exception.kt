package racingcar.Exception

class Exception {
    fun checkValidInput(input: String?) {
        if (input.isNullOrBlank()) { // 사용자의 입력이 null이거나 공백인 경우
            throw IllegalArgumentException("입력 값이 없습니다.")
        }

        if (input.length > 5) {
            throw IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.")
        }

        if (!input.all { it.isLetter()}) { // 이름이 알파벳이 아닌 다른 문자를 포함하는 경우
            throw IllegalArgumentException("자동차의 이름은 알파벳만 가능합니다.")
        }
    }
}