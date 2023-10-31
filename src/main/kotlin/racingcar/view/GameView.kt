package racingcar.view

import racingcar.constants.Constants
import racingcar.constants.Constants.RESULT_WINNER
import racingcar.domain.GameState
import racingcar.io.Printer

class GameView(
    private val printer: Printer
) {
    fun printNameInput() = printer.printNextLine(Constants.INPUT_NAME)
    fun printMoveTimesInput() = printer.printNextLine(Constants.INPUT_MOVE_TIME)
    fun printRacingStart() = printer.printNextLine(Constants.RESULT_RACING)

    fun printRaceState(currentRaceState: List<GameState>) {
        currentRaceState.forEach { (name, range) ->
            printer.printInLine("$name : ")
            repeat(range) { printer.printInLine("-") }
            printer.printNextLine("")
        }
        printer.printNextLine("")
    }

    fun printResult(winnerList: List<String>) {
        printer.printInLine(RESULT_WINNER)
        printer.printNextLine(winnerList.toString().removeSurrounding("[", "]"))
    }
}