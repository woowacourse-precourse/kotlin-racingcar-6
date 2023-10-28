package racingcar.model

class Validation {
    val error: IllegalArgumentException = IllegalArgumentException()
    fun carName(name: String) {
        if (name.length > Constants.NAME_LENGTH) {
            throw error(Constants.ERROR_WORD_MAX)
        } else if (name.length == 0) {
            throw error(Constants.ERROR_WORD_MIN)
        }
    }

}