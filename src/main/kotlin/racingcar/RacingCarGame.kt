package racingcar

class RacingCarGame {
    private val userInputManager = UserInputManager()
    private val racingCarGameMessage = RacingCarGameMessage()
    private val racingCarGameResultEvaluator = RacingCarGameResultEvaluator()
    private val racingCarFactory = RacingCarFactory()
    private val racingCarMovementRecorder = RacingCarMovementRecorder()
    fun gamePlay() {
        racingCarGameMessage.printCarNameInputMessage()
        val names = userInputManager.userNameInput()

        val cars = racingCarFactory.createCars(names)

        racingCarGameMessage.printTryCountInputMessage()
        val tryCount = userInputManager.userTryCountInput()

        racingCarGameMessage.printResultMessage()
        racingCarMovementRecorder.racingCarMovementRecordByTryCount(cars, tryCount)

        val winners = racingCarGameResultEvaluator.racingCarGameJudge(cars)
        racingCarGameMessage.printWinnerMessage(winners)
    }
}