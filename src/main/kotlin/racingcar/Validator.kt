package racingcar

const val NAME_SEPARATOR = ","
const val MAX_NAME_LENGTH = 5
object Validator {
    private fun isEmptyOrBlank(input: String): Boolean {
        return input.isEmpty() || input.isBlank()
    }

    fun validateInput(input: String) {
        if (isEmptyOrBlank(input)) {
            throw IllegalArgumentException("입력이 잘못되었어요.")
        }
    }

    private fun isInvalidCarNameLength(carName: String): Boolean {
        return carName.length > MAX_NAME_LENGTH
    }

    fun validateCarName(carName: String) {
        if (isEmptyOrBlank(carName)) {
            throw IllegalArgumentException("자동차 이름을 잘못 입력했어요.")
        }

        if (isInvalidCarNameLength(carName)) {
            throw IllegalArgumentException("자동차 이름은 ${MAX_NAME_LENGTH}자 이하로 입력해주세요.")
        }
    }

    private fun isInvalidNumeric(input: String): Boolean {
        return !input.all { it.isDigit() }
    }

    fun validateMoveCountInput(moveCountInput: String) {
        if (isInvalidNumeric(moveCountInput)) {
            throw IllegalArgumentException("이동 횟수는 숫자로 입력해주세요.")
        }
    }
}