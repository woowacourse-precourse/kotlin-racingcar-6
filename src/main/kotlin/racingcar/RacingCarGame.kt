package racingcar

class RacingCarGame {
    private val cars = mutableListOf<Car>()
    private val racingCarGameMessage = RacingCarGameMessage()
    private val userInputManager = UserInputManager()
    private val racingCarGameResultEvaluator = RacingCarGameResultEvaluator()
    fun gamePlay() {
        racingCarGameMessage.printCarNameInputMessage()
        val names = userInputManager.userNameInput()
        createCars(names)
        racingCarGameMessage.printTryCountMessage()
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

    private fun createCars(names: MutableList<String>) {
        for(name in names) {
            cars.add(Car(name, 0))
        }
    }

    private fun printAllCarsState() {
        for(car in cars) {
            car.printState()
        }
        println()
    }

    private fun moveAllStep(step: Int) {
        for(i in 0 until step) {
            moveAllCarsOneStep()
            printAllCarsState()
        }
    }
}