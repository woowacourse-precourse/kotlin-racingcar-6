package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.CarListBuilder
import racingcar.domain.attemptValidation
import racingcar.model.Car
import racingcar.domain.RacingState
import racingcar.resources.Comments.ENTER_CAR_NAME_COMMENT
import racingcar.resources.Comments.GAME_RESULT_COMMENT
import racingcar.resources.Comments.NUMBER_OF_ATTEMPT_COMMENT

class PlayRacing(
    private val carListBuilder: CarListBuilder,
) {

    fun start() {
        println(ENTER_CAR_NAME_COMMENT)
        val carList = inputCarNames()

        println(NUMBER_OF_ATTEMPT_COMMENT)
        val attempt = inputAttempt()

        println(GAME_RESULT_COMMENT)
        val winner = racingProcess(carList, attempt)

        print(winner)
    }

    private fun racingProcess(carList: List<Car>, attempt: Int): String {
        val racingState = RacingState(carList)

        repeat(attempt) {
            val movementResult = racingState.moveCarsOnetime()
            println(movementResult)
        }

        return racingState.getWinner()
    }

    private fun inputCarNames(): List<Car> {
        val userInput = Console.readLine()
        return carListBuilder.userInputToCarList(userInput)
    }

    private fun inputAttempt(): Int {
        val userInput = Console.readLine()
        return userInput.also { it.attemptValidation() }.toInt()
    }
}