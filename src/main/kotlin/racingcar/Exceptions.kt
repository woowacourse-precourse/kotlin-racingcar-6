package racingcar

object Exceptions {
    fun inputCarNameException(input: String?): List<String> {

        if (input == null) {
            throw IllegalArgumentException("입력이 없습니다.")
        } else {
            val carNames = input.split(",").map { it.trim() }

            when {
                carNames.any { it.isBlank() } -> {
                    throw IllegalArgumentException("이름을 공백으로 입력할 수 없습니다.")
                }

                carNames.size < 2 -> {
                    throw IllegalArgumentException("이름은 최소 2개 이상 입력 해야 합니다.")
                }

                carNames.all { it.length <= 5 } -> {
                    return carNames
                }

                else -> {
                    throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
                }
            }
        }
    }

    fun inputTryCountException(input: String?): Int {
        if (input != null && input.all { it.isDigit() } && input.toInt() != 0) {
            val tryCountInt = input.toInt()
            if (tryCountInt > 0) {
                return tryCountInt
            }
        }
        throw IllegalArgumentException("올바른 숫자를 입력해주세요.")
    }
}