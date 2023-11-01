package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.model.RacingCar
import racingcar.utils.Constants
import racingcar.utils.toRacingCar

class UserInput {

    fun getNameInput(): List<RacingCar> {
        println(Constants.NAME_INPUT_MESSAGE)
        val userInput = Console.readLine()
        require(userInput.isNullOrBlank())
        val carList = userInput.split(',').map { it.toRacingCar() }
        require(hasDuplication(carList))
        return carList
    }

    private fun hasDuplication(list: List<RacingCar>): Boolean =
        list.size != list.distinctBy { car -> car.carName }.size

    fun getTrialInput(): Int {
        println(Constants.TRIAL_INPUT_MESSAGE)
        val userInput = Console.readLine()
        return when {
            userInput.isNullOrBlank() -> throw IllegalArgumentException()
            userInput.toIntOrNull() == null -> throw IllegalArgumentException()
            userInput.toInt() == 0 -> throw IllegalArgumentException()
            else -> userInput.toInt()
        }
    }
}