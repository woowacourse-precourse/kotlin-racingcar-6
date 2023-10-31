package racingcar

class RacingGame {

    private val host = Host()
    private val player = Player()
    private val validation = Validation()

    fun start() {
        val carNamesList = getCarNames()
        val numberOfAttempt = getNumberOfAttempt()
        val playersFinalPosition = printRaceResult(numberOfAttempt, carNamesList)
        host.printWinner(playersFinalPosition, carNamesList)
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
        validation.checkNumberOfAttemptOneAndMore(numberOfAttempt)

        return numberOfAttempt
    }

    private fun printRaceResult(numberOfAttempt: Int, cars: List<Car>): List<Int> {
        var playersFinalPosition = mutableListOf<Int>()

        println("\n실행 결과")
        for (i in 0 until numberOfAttempt) {
            playersFinalPosition = host.printCurrentRaceSituation(cars).toMutableList()
            println()
        }

        return playersFinalPosition
    }

}