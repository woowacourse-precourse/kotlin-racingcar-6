package racingcar

const val MIN_LENGTH_CAR_LIST = 2
const val MIN_LENGTH_ATTEMPTS = 1
const val MAX_LENGTH_CAR_NAMES = 5

class InputValidate {
    fun validateCarNames(names: List<String>) {
        if (names.size < MIN_LENGTH_CAR_LIST) {
            throw IllegalArgumentException("적어도 두 대 이상의 자동차가 필요합니다.")
        }
        if (names.distinct().size != names.size) {
            throw IllegalArgumentException("중복된 이름의 자동차가 존재합니다.")
        }
        names.forEach { name ->
            if (name.isBlank()) {
                throw IllegalArgumentException("이름에 공백이 존재합니다.")
            }
            if (name.length > MAX_LENGTH_CAR_NAMES) {
                throw IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.")
            }
        }
    }

    fun validateAttempts(attempts: String): Int{
        val convertedAttempts = attempts.toIntOrNull()
            ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
        if (convertedAttempts < MIN_LENGTH_ATTEMPTS) {
            throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
        }
        return convertedAttempts
    }
}