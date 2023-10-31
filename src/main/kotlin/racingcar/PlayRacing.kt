package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.CarList
import racingcar.domain.attemptValidation
import racingcar.model.Car
import racingcar.domain.RacingState
import racingcar.resources.Comments.ENTER_CAR_NAME_COMMENT
import racingcar.resources.Comments.GAME_RESULT_COMMENT
import racingcar.resources.Comments.NUMBER_OF_ATTEMPT_COMMENT

class PlayRacing(
    private val carList: CarList,
) {

    fun initProcess() {
        val carList = inputRacingCarsName()
        val attempt = inputAttempt().toInt()

        println(GAME_RESULT_COMMENT)
        val winner = racingProcess(carList, attempt)

        println(winner)
    }

    private fun racingProcess(carList: List<Car>, attempt: Int): String {
        val racingState = RacingState(carList)

        repeat(attempt) {
            val movementResult = racingState.moveCarsOnetime()
            println(movementResult)
        }

        return racingState.getWinner()
    }

    private fun inputRacingCarsName(): List<Car> {
        println(ENTER_CAR_NAME_COMMENT)
        val userInput = Console.readLine()
        return carList.userInputToCarList(userInput)
    }

    private fun inputAttempt(): String {
        println(NUMBER_OF_ATTEMPT_COMMENT)
        val userInput = Console.readLine()
        return userInput.also { it.attemptValidation() }
    }
}