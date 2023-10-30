package racingcar.domain

import racingcar.constants.Constants
import racingcar.io.Printer
import racingcar.io.Reader
import racingcar.utils.InputChecker

class CarNames(
    private val reader: Reader,
    private val printer: Printer,
    private val inputChecker: InputChecker
) {

    fun inputCarNames() {
        printer.printNextLine(Constants.INPUT_NAME)
        val nameList = inputChecker.checkInputNames(reader.readLine())

        nameList.map { name ->
            if (name != nameList.last()) {
                printer.printInLine("$name,")
            } else {
                printer.printNextLine(name)
            }
        }
    }
}