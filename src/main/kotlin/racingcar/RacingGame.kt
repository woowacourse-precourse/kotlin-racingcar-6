package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame {

    private fun userInput() = Console.readLine()

    fun playRacing() {
        val printer = Printer()

        printer.printOutEnteringCarName()
        val inputString = userInput()

        val carsList = inputString.split(",").filter { it.isNotBlank() }.map { Car(it) }
        requireCompareNumberOfCarAndNumberOfComma(inputString, carsList)
    }

    private fun requireCompareNumberOfCarAndNumberOfComma(inputString: String, carsList: List<Car>) {
        require(inputString.count { it == ',' } == carsList.size - 1)
    }
}