package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame(
    private val printer: Printer = Printer()
) {

    private fun userInput() = Console.readLine()

    fun readyRacing() {
        printer.printOutEnteringCarName()
        val carsInputString = userInput()

        val carsList = carsInputString.split(",").filter { it.isNotBlank() }.map { Car(it) }
        requireValidCarsInput(carsInputString = carsInputString, carsList = carsList)
        requireCheckingForDuplicateNames(carsList = carsList)

        printer.printOutEnteringAttemptsNumber()
        val attemptsNumberInputString = userInput()
        requireValidAttemptsNumberInput(attemptsNumberInputString = attemptsNumberInputString)
        val attemptsNumber = attemptsNumberInputString.toInt()

        startRacing(attemptsNumber = attemptsNumber, carsList = carsList)
    }

    private fun startRacing(attemptsNumber: Int, carsList: List<Car>) {
        var attempts = attemptsNumber
        printer.printOutResultInformationText()

        while (attempts > 0) {
            carsList.map { car ->
                car.moveForward()
            }
            printer.printOutCarsMoveResult(carsList = carsList)
            attempts--
        }
    }

    private fun requireValidCarsInput(carsInputString: String, carsList: List<Car>) {
        require(carsInputString.count { it == ',' } == carsList.size - 1)
        require(carsInputString.length <= carsList.size * CARS_MAX_LENGTH + carsInputString.count { it == ',' })
    }

    private fun requireCheckingForDuplicateNames(carsList: List<Car>) {
        val nameSet = mutableSetOf<String>()
        for (car in carsList) {
            require(car.getCarName() !in nameSet)
            nameSet.add(car.getCarName())
        }
    }

    private fun requireValidAttemptsNumberInput(attemptsNumberInputString: String) {
        require(attemptsNumberInputString.matches(Regex("^\\d+\$")))
        require(attemptsNumberInputString.toInt() >= 0)
    }

    companion object {
        const val CARS_MAX_LENGTH = 5
    }

}