package racingcar

object Converter {
    fun convertStringToMap(input: String) = input.split(",").map { it.trim() }.associateWith { 0 }
}
