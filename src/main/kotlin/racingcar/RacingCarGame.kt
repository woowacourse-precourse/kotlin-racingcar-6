package racingcar

class RacingCarGame {
    private val cars = mutableListOf<Car>()
    private val userInputManager = UserInputManager()
    private val racingCarGameMessage = RacingCarGameMessage()
    private val racingCarGameResultEvaluator = RacingCarGameResultEvaluator()
    private val racingCarFactory = RacingCarFactory()
    private val racingCarGameStatePrinter = RacingCarGameStatePrinter()
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

    private fun moveAllCarsOneStep() {
        for(car in cars) {
            car.move()
        }
    }

    private fun moveAllStep(step: Int) {
        for(i in 0 until step) {
            moveAllCarsOneStep()
            racingCarGameStatePrinter.printAllCarsState(cars)
        }
    }
}