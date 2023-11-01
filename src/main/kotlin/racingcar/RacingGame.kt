package racingcar

class RacingGame {

    private val host = Host()
    private val player = Player()
    private val validation = Validation()

    fun start() {
        val carNamesList = getCarNames()
        val numberOfAttempt = getNumberOfAttempt()

        showGameHeader()
        val carsFinalPosition = printRaceResult(numberOfAttempt, carNamesList)

        val winners = host.determineWinners(carsFinalPosition, carNamesList)
        host.printWinners(winners)
    }

    private fun getCarNames(): List<Car> {
        host.printRequestEnterCarName()
        val inputCarNames = player.inputCarsName()
        val carNames = inputCarNames.split(COMMA)
        val cars = mutableListOf<Car>()
        for (name in carNames) {
            cars.add(Car(name))
        }
        validation.isValidCarName(inputCarNames, cars)

        return cars
    }

    private fun getNumberOfAttempt(): Int {
        host.printQuestionNumberOfAttempt()
        val numberOfAttempt = player.inputNumberOfAttempt()

        return validation.isValidNumberOfAttempt(numberOfAttempt)
    }

    private fun showGameHeader() {
        println(EXECUTION_RESULT)
    }

    fun printRaceResult(
        numberOfAttempt: Int,
        cars: List<Car>,
        race: (List<Car>) -> List<Int> = { host.printCurrentRaceSituation(it) }
    ): List<Int> {
        var carsFinalPosition = listOf<Int>()

        for (i in FIRST_ATTEMPT until numberOfAttempt) {
            carsFinalPosition = race(cars)
            println()
        }

        return carsFinalPosition
    }

}