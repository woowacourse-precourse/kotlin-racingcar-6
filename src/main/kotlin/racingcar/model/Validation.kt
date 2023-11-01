package racingcar.model

class Validation {
    val error: IllegalArgumentException = IllegalArgumentException()
    fun carName(names: List<String>) {
        for (name in names) {
            if (name.length > Constants.NAME_LENGTH) {
                throw IllegalArgumentException(Constants.ERROR_WORD_MAX)
            } else if (name.length == Constants.MIN) {
                throw IllegalArgumentException(Constants.ERROR_WORD_MIN)
            } else if (name.contains(Constants.SPACE_BAR)){
                throw IllegalArgumentException(Constants.ERROR_WORD_EMPTY_SPACE)
            }
        }
    }

    fun tryNum(tryNum: String): Int {
        val num: Int = try {
            tryNum.toInt()
        } catch (e: NumberFormatException) {
            error(Constants.ERROR_NUMBER_VALIDITY)
        }
        return num
    }

}