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
    fun tryNum(tryNum: String) :Int{
        val Num:Int
        try {
            Num = tryNum.toInt()
        } catch (e:NumberFormatException){
            error(Constants.ERROR_NUMBER_VALIDITY)
        }
        return Num
    }

}