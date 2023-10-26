package racingcar.game

object PrintUtil {
    private const val START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ASK_ATTEMPTS = "시도할 횟수는 몇 회인가요?"

    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printAskAttempts() {
        println(ASK_ATTEMPTS)
    }
}