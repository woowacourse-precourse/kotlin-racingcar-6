package racingcar

object Converter {
    fun convertStringToMap(input: String) = input.split(",").map { it.trim() }.associateWith { 0 }

    fun convertStringToInt(input: String) = input.toInt()
}
