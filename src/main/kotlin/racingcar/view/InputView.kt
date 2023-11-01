package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.config.ExceptionMessage.INVALID_INTEGER
import racingcar.config.GameConfig.MIN_TRY_COUNT

class InputView {

    fun cars(cars: String = Console.readLine()): List<String> =
        cars.split(DELIMITER).map { it.trim() }

    fun tryCount(tryCount: String = Console.readLine()): Int {
        val count = tryCount.toIntOrNull()
        return when {
            count == null || count < MIN_TRY_COUNT -> {
                throw IllegalArgumentException(INVALID_INTEGER)
            }

            else -> count
        }
    }

    companion object {
        const val DELIMITER = ","
    }

}