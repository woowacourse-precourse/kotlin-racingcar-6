package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputCars(cars: String = Console.readLine()): List<String> =
        cars.split(DELIMITER).map { it.trim() }

    fun inputTryCount(tryCount: String = Console.readLine()): Int {
        val count = tryCount.toIntOrNull()
        return when {
            count == null || count <= 0 -> {
                throw IllegalArgumentException("${Integer.MAX_VALUE} 이하의 자연수를 입력해주세요.")
            }

            else -> count
        }
    }

    companion object {
        const val DELIMITER = ", "
    }

}