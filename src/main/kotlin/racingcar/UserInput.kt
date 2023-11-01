package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.model.RacingCar
import racingcar.utils.Constants
import racingcar.utils.toRacingCar

class UserInput {

    fun getNameInput(): List<RacingCar> {
        println(Constants.NAME_INPUT_MESSAGE)
        val userInput = inputWithNullOrBlankCheck()
        val carList = userInput.split(',').map { it.toRacingCar() }
        require(!hasDuplication(carList)) { "자동차 이름은 중복해서 입력할 수 없습니다." }

        return carList
    }

    private fun hasDuplication(list: List<RacingCar>): Boolean =
        list.size != list.distinctBy { car -> car.carName }.size

    fun getTrialInput(): Int {
        println(Constants.TRIAL_INPUT_MESSAGE)
        val userInput = inputWithNullOrBlankCheck()
        return when {
            userInput.toIntOrNull() == null -> throw IllegalArgumentException("숫자가 아닙니다.")
            userInput.toInt() < 0 -> throw IllegalArgumentException("경기 횟수는 1회 이상 진행되어야 합니다.")
            else -> userInput.toInt()
        }
    }

    private fun inputWithNullOrBlankCheck() =
        Console.readLine() ?: throw IllegalArgumentException("입력값이 없습니다.")
}