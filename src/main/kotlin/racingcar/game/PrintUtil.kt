package racingcar.game

object PrintUtil {
    private const val START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"

    fun printStartMessage() {
        println(START_MESSAGE)
    }
}