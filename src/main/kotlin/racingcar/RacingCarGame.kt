package racingcar

class RacingCarGame {
    private val cars = mutableListOf<RacingCar>()
    private val userInputManager = UserInputManager()
    private val racingCarGameMessage = RacingCarGameMessage()
    private val racingCarGameResultEvaluator = RacingCarGameResultEvaluator()
    private val racingCarFactory = RacingCarFactory()
    private val racingCarGameStatePrinter = RacingCarGameStatePrinter()
    private val racingCarManager = RacingCarManager()
    fun gamePlay() {
        racingCarGameMessage.printCarNameInputMessage()
        val names = userInputManager.userNameInput()
        racingCarFactory.createCars(cars, names)
        racingCarGameMessage.printTryCountInputMessage()
        val tryCount = userInputManager.userTryCountInput()
        racingCarGameMessage.printResultMessage()
        moveAllStep(tryCount)
        val winners = racingCarGameResultEvaluator.racingCarGameJudge(cars)
        racingCarGameMessage.printWinnerMessage(winners)
    }

    private fun moveAllStep(step: Int) {
        for(i in 0 until step) {
            racingCarManager.moveAllCars(cars)
            racingCarGameStatePrinter.printAllCarsState(cars)
        }
    }
}