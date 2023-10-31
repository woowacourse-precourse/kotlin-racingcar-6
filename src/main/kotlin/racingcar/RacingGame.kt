package racingcar

class RacingGame {

    private val host = Host()
    private val player = Player()
    private val validation = Validation()

    fun start() {
        val carNamesList = getCarNames()
        val numberOfAttempt = getNumberOfAttempt()
        printResult(numberOfAttempt, carNamesList)
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

    private fun printResult(numberOfAttempt: Int, carList: List<Car>) {
        println("\n실행 결과")
        for (i in 0 until numberOfAttempt) {
            host.printRaceResults(carList)
            println()
        }
    }

}