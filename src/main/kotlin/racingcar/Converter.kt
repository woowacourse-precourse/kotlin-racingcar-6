package racingcar

object Converter {
    fun convertStringToCars(input: String): List<Car> = input.split(",").map { Car(it.trim()) }

    fun convertStringToInt(input: String) = input.toInt()
}
