package racingcar.domain

import racingcar.constants.Constants
import racingcar.io.Printer
import racingcar.io.Reader
import racingcar.utils.InputChecker

class MoveTimes(
    private val reader: Reader,
    private val printer: Printer,
    private val inputChecker: InputChecker
) {
    fun inputMoveTimes(): Int {
        printer.printNextLine(Constants.INPUT_MOVE_TIME)
        val moveTime = inputChecker.checkMoveTimes(reader.readLine())

        return moveTime.toInt()
    }
}