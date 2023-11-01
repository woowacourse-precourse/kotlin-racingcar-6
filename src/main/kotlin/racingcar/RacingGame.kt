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
        val carNames = inputCarNames.split(",")
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
        println("\n실행 결과")
    }

    fun printRaceResult(
        numberOfAttempt: Int,
        cars: List<Car>,
        raceFunction: (List<Car>) -> List<Int> = { host.printCurrentRaceSituation(it) }
    ): List<Int> {
        var carsFinalPosition = listOf<Int>()

        for (i in 0 until numberOfAttempt) {
            carsFinalPosition = raceFunction(cars)
            println()
        }

        return carsFinalPosition
    }

}