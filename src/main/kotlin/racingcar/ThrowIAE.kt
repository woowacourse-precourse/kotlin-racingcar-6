package racingcar

class ThrowIAE {

    fun checkBlankOrEmpty(string: String?) {
        if (string.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
        if(string.isEmpty()){
            throw IllegalArgumentException()
        }
    }

    fun checkLength(string: String, length: Int) {
        if (string.length > length) {
            throw IllegalArgumentException()
        }
    }

    fun checkToInt(string: String): Int {
        try {
            return string.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }
}