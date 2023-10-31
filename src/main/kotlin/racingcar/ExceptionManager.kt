package racingcar

object ExceptionManager {
    const val MAX_CARS_STRING_NUMBER = 5

    fun validateCars(cars: List<String>) {
        cars.forEach {
            if (it.length > MAX_CARS_STRING_NUMBER || it.isEmpty()) throw IllegalArgumentException()
        }
    }

    fun validateExecutionNumber(numberString: String){
        val number = numberString.toIntOrNull()
        if (number == null || number < 0) {
            throw IllegalArgumentException()
        }
    }
}