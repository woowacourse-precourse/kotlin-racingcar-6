package racingcar.exception

class UserInputException {
    companion object {
        fun checkCarNameLength(userInput: List<String>) {
            for (carName in userInput) {
                if (carName.length >= 6) throw IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.")
            }
        }

        fun isNumber(userInput: String) {
            for (numberIndex in 0 until userInput.length) {
                if (userInput[numberIndex].code < '0'.code || userInput[numberIndex].code > '9'.code) throw IllegalArgumentException(
                    "입력값은 숫자여야 합니다."
                )
            }
        }
    }
}