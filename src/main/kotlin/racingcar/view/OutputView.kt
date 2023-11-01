package racingcar.view

import racingcar.model.RacingCar
import racingcar.utils.Constant.ATTEMPTS_NUM_PROMPT_MESSAGE
import racingcar.utils.Constant.CAR_NAME_PROMPT_MESSAGE
import racingcar.utils.Constant.GAME_RESULT_MESSAGE
import racingcar.utils.Constant.GAME_WINNER_MESSAGE
import racingcar.utils.Constant.RACING_CAR_RESULT_MESSAGE

class OutputView {
    fun printCarNamePrompt() = println(CAR_NAME_PROMPT_MESSAGE)
    fun printAttemptsPrompt() = println(ATTEMPTS_NUM_PROMPT_MESSAGE)
    fun printCarRaceResults(racingCars: List<RacingCar>) {
        racingCars.forEach { racingCar ->
            println(RACING_CAR_RESULT_MESSAGE.format(racingCar.name, racingCar.raceRecord))
        }
        printEmptyLine()
    }

    fun printGameWinner(winners: String) = println(GAME_WINNER_MESSAGE.format(winners))
    fun printEmptyLine() = println()
    fun printGameResult() = println(GAME_RESULT_MESSAGE)
}