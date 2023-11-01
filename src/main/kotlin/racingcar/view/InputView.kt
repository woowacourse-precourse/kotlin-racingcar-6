package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.config.ExceptionMessage.INVALID_INTEGER

class InputView {

    fun inputCars(cars: String = Console.readLine()): List<String> =
        cars.split(DELIMITER).map { it.trim() }

    fun inputTryCount(tryCount: String = Console.readLine()): Int {
        val count = tryCount.toIntOrNull()
        return when {
            count == null || count <= 0 -> {
                throw IllegalArgumentException(INVALID_INTEGER)
            }

            else -> count
        }
    }

    companion object {
        const val DELIMITER = ","
    }

}