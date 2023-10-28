package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.CarList
import racingcar.domain.attemptValidation
import racingcar.model.Car
import racingcar.model.RacingCars
import racingcar.resources.Comments.ENTER_CAR_NAME_COMMENT
import racingcar.resources.Comments.GAME_RESULT_COMMENT
import racingcar.resources.Comments.NUMBER_OF_ATTEMPT_COMMENT

class PlayRacing(
    private val carList: CarList,
) {

    fun playRacing() {
        val racingCarList = inputRacingCarsName()
        val attempt = inputAttempt()

        println(GAME_RESULT_COMMENT)
        val racingCars = RacingCars(racingCarList)

        repeat(attempt) {
            racingCars.moveRacingCars()
            racingCars.getMovementResult().forEach {
                println(it)
            }
            println()
        }

        println(racingCars.getWinner())
    }

    private fun inputRacingCarsName(): List<Car> {
        println(ENTER_CAR_NAME_COMMENT)
        val userInput = Console.readLine()
        return carList.userInputToCarList(userInput)
    }

    private fun inputAttempt(): Int {
        println(NUMBER_OF_ATTEMPT_COMMENT)
        val userInput = Console.readLine()
        userInput.attemptValidation()
        return userInput.toInt()
    }
}