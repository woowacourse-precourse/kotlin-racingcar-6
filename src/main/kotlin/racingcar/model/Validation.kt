package racingcar.model

class Validation {
    fun carNameValidate(names: List<String>) {
        for (name in names) {
            if (name.length > Constants.NAME_LENGTH) {
                throw IllegalArgumentException(Constants.ERROR_WORD_MAX)
            } else if (name.length == Constants.MIN) {
                throw IllegalArgumentException(Constants.ERROR_WORD_MIN)
            } else if (name.contains(Constants.SPACE_BAR)) {
                throw IllegalArgumentException(Constants.ERROR_WORD_EMPTY_SPACE)
            }
        }
    }

    fun tryNumValidate(tryNum: String) {
        try {
            tryNum.toInt()
        } catch (e: NumberFormatException) {
            error(Constants.ERROR_NUMBER_VALIDITY)
        }
    }

}