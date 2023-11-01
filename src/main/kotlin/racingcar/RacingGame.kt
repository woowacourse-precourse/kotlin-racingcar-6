package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame(
    private val printer: Printer = Printer()
) {

    private lateinit var carsList: List<Car>

    private var attemptsNumber: Int = 0

    private fun userInput() = Console.readLine()

    fun execute() {
        stepToEnterCarNames()
        stepToEnterTheNumberOfAttempts()
        stepInWhichRacingIsCarriedOut()
        stepToChooseWinners()
    }

    private fun stepToEnterCarNames() {
        printer.printOutEnteringCarName()
        val carsInputString = userInput()
        carsList = createCarsList(carsInputString)
    }

    fun createCarsList(carsInputString: String): List<Car> {
        val tempCarsList = carsInputString.split(",").map { Car(it) }
        val nameSet = mutableSetOf<String>()
        for (car in tempCarsList) {
            require(car.name !in nameSet)
            nameSet.add(car.name)
        }
        return tempCarsList
    }

    private fun stepToEnterTheNumberOfAttempts() {
        printer.printOutEnteringAttemptsNumber()
        val attemptsNumberInput = userInput()
        attemptsNumber = createAttemptsNumber(attemptsNumberInput)
    }

    fun createAttemptsNumber(input: String): Int {
        val count = input.toIntOrNull() ?: throw IllegalArgumentException()
        require(count > 0)
        return count
    }

    private fun stepInWhichRacingIsCarriedOut() {
        printer.printOutResultInformationText()

        while (attemptsNumber > 0) {
            carsList.map { car ->
                car.moveForward()
            }
            printer.printOutCarsMoveResult(carsList = carsList)
            attemptsNumber--
        }
    }

    private fun stepToChooseWinners() {
        val maxHowGoForwardCars = carsList.maxByOrNull { it.howGoForwardCount }
        requireNotNull(maxHowGoForwardCars)

        val winners = carsList.filter { it.howGoForwardCount == maxHowGoForwardCars.howGoForwardCount }
        if (winners.size > 1) {
            val winnersName = winners.joinToString(",") { it.name }
            printer.printOutRacingWinner(winnersName)
        } else {
            printer.printOutRacingWinner(winners[0].name)
        }
    }

}