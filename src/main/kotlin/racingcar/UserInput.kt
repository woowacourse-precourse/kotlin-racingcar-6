package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.model.RacingCar
import racingcar.utils.Constants
import racingcar.utils.toRacingCar

class UserInput {
    fun getNameInput(): List<RacingCar> {
        println(Constants.NAME_INPUT_MESSAGE)
        val userInput = Console.readLine()
        return when {
            userInput.isNullOrBlank() -> throw IllegalArgumentException()
            else -> userInput.split(',').map {
                it.toRacingCar()
            }
        }
    }
}