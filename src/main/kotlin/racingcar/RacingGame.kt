package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame(
    private val printer: Printer = Printer(),
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

    fun stepToEnterCarNames() {
        printer.printOutEnteringCarName()
        val carsInputString = userInput()
        carsList = carsInputString.split(",").filter { it.isNotBlank() }.map { Car(it) }

        requireValidCarsInput(carsInputString = carsInputString)
        requireCheckingForDuplicateNames()
    }

    fun stepToEnterTheNumberOfAttempts() {
        printer.printOutEnteringAttemptsNumber()
        val attemptsNumberInput = userInput()
        requireValidAttemptsNumberInput(attemptsNumberInput = attemptsNumberInput)
        attemptsNumber = attemptsNumberInput.toInt()
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
    
    private fun requireValidCarsInput(carsInputString: String) {
        require(carsInputString.count { it == ',' } == carsList.size - 1)
        require(carsInputString.length <= carsList.size * CARS_MAX_LENGTH + carsInputString.count { it == ',' })
    }

    private fun requireCheckingForDuplicateNames() {
        val nameSet = mutableSetOf<String>()
        for (car in carsList) {
            require(car.name !in nameSet)
            nameSet.add(car.name)
        }
    }

    private fun requireValidAttemptsNumberInput(attemptsNumberInput: String) {
        require(attemptsNumberInput.matches(Regex(Message.ONLY_NUMBER_PATTERN)))
        require(attemptsNumberInput.toInt() >= 0)
    }

    companion object {
        const val CARS_MAX_LENGTH = 5
    }

}