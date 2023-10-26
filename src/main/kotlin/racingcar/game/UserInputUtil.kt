package racingcar.game

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

object UserInputUtil {
    private const val ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_EMPTY_DATA = "잘못된 입력 값입니다.(자동차 없음)"
    private const val ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_SAME_NAME = "잘못된 입력 값입니다.(중복 이름 발생)"
    private const val ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_NAME_LENGTH = "잘못된 입력 값입니다.(이름의 길이가 유효하지 않음)"
    private const val ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_NOT_NATURAL_NUMBER = "잘못된 입력 값입니다. (시도횟수에 자연수가 아닌 값 입력)"
    private val NAME_LENGTH_RANGE = 1..5

    fun getRacingCars(): List<Car> {
        val racingCars = Console.readLine().split(",").map {_name ->
            checkRacingCarNameAvailable(_name)
        }
        checkRacingCarsAvailable(racingCars)
        return racingCars
    }

    private fun checkRacingCarNameAvailable(carName: String): Car {
        val removeSpaceName = carName.replace(" ", "")
        if (removeSpaceName.length in NAME_LENGTH_RANGE) {
            return Car(removeSpaceName)
        }
        else {
            throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_NAME_LENGTH)
        }
    }

    private fun checkRacingCarsAvailable(racingCars: List<Car>) {
        if (racingCars.isEmpty()) {
            throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_EMPTY_DATA)
        }

        if (racingCars.size != racingCars.toSet().size) {
            throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_SAME_NAME)
        }
    }

    fun getAttempts(): Int =
        try {
            Console.readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE_NOT_NATURAL_NUMBER)
        }

}