package racingcar.constants

enum class Delimiter(private val value: String) {
    CAR(","),
    WINNER(", "),
    RESULT(" : ");

    override fun toString(): String = value
}