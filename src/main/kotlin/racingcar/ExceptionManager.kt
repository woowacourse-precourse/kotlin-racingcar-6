package racingcar

object ExceptionManager {
    const val MAX_CARS_STRING_NUMBER = 5

    fun carException(carString: List<String>) {
        carString.forEach {
            if (it.length > MAX_CARS_STRING_NUMBER || it.isEmpty()) throw IllegalArgumentException()
        }
    }

    fun executionNumberException(numberString: String){
        try {
            val number = numberString.toInt()
            if (number < 0 ) throw IllegalArgumentException()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }
}