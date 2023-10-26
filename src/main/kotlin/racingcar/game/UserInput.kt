package racingcar.game

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

object UserInput {
    private const val ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_EMPTY_DATA = "잘못된 입력 값입니다.(자동차 없음)"
    private const val ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_SAME_NAME = "잘못된 입력 값입니다.(중복 이름 발생)"
    private const val ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_NAME_LENGTH = "잘못된 입력 값입니다.(이름의 길이가 유효하지 않음)"
    private val NAME_LENGTH_RANGE = 1..5

    fun getRacingCars(): List<Car> {
        val racingCars = Console.readLine().split(", ").map {_name ->
            if (_name.length in NAME_LENGTH_RANGE) {
                Car(_name)
            }
            else {
                throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_NAME_LENGTH)
            }
        }
        checkRacingCarsAvailable(racingCars)
        return racingCars
    }

    private fun checkRacingCarsAvailable(racingCars: List<Car>) {
        if (racingCars.isEmpty()) {
            throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_EMPTY_DATA)
        }

        if (racingCars.size != racingCars.toSet().size) {
            throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_SAME_NAME)
        }
    }

    fun getAttempts(): Int = Console.readLine()!!.toInt()
}