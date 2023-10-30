package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame {

    private fun userInput() = Console.readLine()

    fun playRacing() {
        val printer = Printer()

        printer.printOutEnteringCarName()
        val carsInputString = userInput()

        val carsList = carsInputString.split(",").filter { it.isNotBlank() }.map { Car(it) }
        requireValidCarsInput(carsInputString = carsInputString, carsList = carsList)

        printer.printOutEnteringAttemptsNumber()
        val attemptsNumberInputString = userInput()
        requirePositiveNumber(attemptsNumberInputString = attemptsNumberInputString)
        val attemptsNumber = attemptsNumberInputString.toInt()

    }

    private fun requireValidCarsInput(carsInputString: String, carsList: List<Car>) {
        require(carsInputString.count { it == ',' } == carsList.size - 1)

    }

    private fun requirePositiveNumber(attemptsNumberInputString: String) {
        require(attemptsNumberInputString.matches(Regex("^\\d+\$")))
        require(attemptsNumberInputString.toInt() >= 0)
    }

}