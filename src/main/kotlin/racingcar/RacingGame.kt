package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame {

    private fun userInput() = Console.readLine()

    fun readyRacing() {
        val printer = Printer()

        printer.printOutEnteringCarName()
        val carsInputString = userInput()

        val carsList = carsInputString.split(",").filter { it.isNotBlank() }.map { name ->

            Car(name)
        }
        requireValidCarsInput(carsInputString = carsInputString, carsList = carsList)
        requireCheckingForDuplicateNames(carsList = carsList)

        printer.printOutEnteringAttemptsNumber()
        val attemptsNumberInputString = userInput()
        requireValidAttemptsNumberInput(attemptsNumberInputString = attemptsNumberInputString)
        val attemptsNumber = attemptsNumberInputString.toInt()

        startRacing(attemptsNumber = attemptsNumber)
    }

    private fun startRacing(attemptsNumber: Int) {
        var attempts = attemptsNumber
        while (attempts > 0) {


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