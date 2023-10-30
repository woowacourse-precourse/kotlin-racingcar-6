package racingcar

class RacingGame {

    private val host = Host()
    private val validation = Validation()

    fun startGame() {
        host.printRequestEnterCarName()
        validation.isValidCarName()
        host.printQuestionNumberOfAttempt()
        validation.isValidNumberOfAttempt()
    }

}