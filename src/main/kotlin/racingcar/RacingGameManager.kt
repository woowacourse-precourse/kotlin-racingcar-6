package racingcar

class RacingGameManager {

    fun run() {
        printGameStart()
    }

    private fun printGameStart() = println(Message.INPUT_CAR_NAME.message)
}