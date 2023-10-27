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

    fun moveAllCarsOneStep() {
        for(car in cars) {
            car.move()
        }
    }

    fun createCars(names: MutableList<String>) {
        for(name in names) {
            cars.add(Car(name, 0))
        }
    }

    fun printAllCarsState() {
        for(car in cars) {
            car.printState()
        }
        println()
    }

    fun moveAllStep(step: Int) {
        for(i in 0 until step) {
            moveAllCarsOneStep()
            printAllCarsState()
        }
    }
}