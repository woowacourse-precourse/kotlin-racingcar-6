package racingcar

class RacingCarGameMessage {
    companion object {
        const val CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val RESULT_MESSAGE = "실행 결과"
    }

    fun printCarNameInputMessage() {
        println(CAR_NAME_INPUT_MESSAGE)
    }

    fun printTryCountMessage() {
        println(TRY_COUNT_MESSAGE)
    }

    fun printResultMessage() {
        println(RESULT_MESSAGE)
    }

    fun printWinnerMessage(winners: MutableList<String>) {
        print("최종 우승자 : ${winners.joinToString(", ")}")
    }
}