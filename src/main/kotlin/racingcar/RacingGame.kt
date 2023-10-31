package racingcar

class RacingGame {

    private val host = Host()
    private val player = Player()
    private val validation = Validation()

    fun start() {
        val carNamesList = getCarNames()
        val numberOfAttempt = getNumberOfAttempt()
        val maxPosition = printResult(numberOfAttempt, carNamesList)
        host.printWinner(maxPosition, carNamesList)
    }

    private fun getCarNames(): List<Car> {
        host.printRequestEnterCarName()
        val inputCarNames = player.inputCarsName()
        val carNames = inputCarNames.split(",")
        val carList = mutableListOf<Car>()
        for (name in carNames) {
            carList.add(Car(name))
        }
        validation.isValidCarName(inputCarNames, carList)

        return carList
    }

    private fun getNumberOfAttempt(): Int {
        host.printQuestionNumberOfAttempt()
        val numberOfAttempt = player.inputNumberOfAttempt()
        validation.checkNumberOfAttemptOneAndMore(numberOfAttempt)

        return numberOfAttempt
    }

    private fun printResult(numberOfAttempt: Int, carList: List<Car>): List<Int> {
        var playersFinalPosition = mutableListOf<Int>()

        println("\n실행 결과")
        for (i in 0 until numberOfAttempt) {
            playersFinalPosition = host.printRaceResults(carList).toMutableList()
            println()
        }

        return playersFinalPosition
    }

}