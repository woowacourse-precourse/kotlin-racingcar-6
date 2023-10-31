package racingcar.view

import racingcar.constants.Constants
import racingcar.domain.GameState
import racingcar.io.Printer

class GameView(
    private val printer: Printer
) {
    fun requireName() = printer.printNextLine(Constants.INPUT_NAME)
    fun requireMoveTimes() = printer.printNextLine(Constants.INPUT_MOVE_TIME)
    fun startRacing() = printer.printNextLine(Constants.RESULT_RACING)

    fun showCurrentRace(currentRaceState: List<GameState>) {
        currentRaceState.forEach { (name, range) ->
            printer.printInLine("$name : ")
            repeat(range) { printer.printInLine("-") }
            printer.printNextLine("")
        }
        printer.printNextLine("")
    }
}