package racingcar.utils

import racingcar.game.Car

object TypeConverter {

    private const val ERROR_INVALID_TYPE_STRING_TO_INT = "숫자만 입력이 가능합니다."

    fun stringToCarList(input: String): List<Car> = input.split(",").map { Car(it.trim()) }
    fun stringToInt(input: String): Int = input.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_TYPE_STRING_TO_INT)
}