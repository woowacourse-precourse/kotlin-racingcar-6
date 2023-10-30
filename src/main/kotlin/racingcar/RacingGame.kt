package racingcar

class RacingGame {

    private val host = Host()
    private val validation = Validation()

    fun start() {
        host.printRequestEnterCarName()
        validation.isValidCarName()
        host.printQuestionNumberOfAttempt()
        validation.isValidNumberOfAttempt()
    }

}