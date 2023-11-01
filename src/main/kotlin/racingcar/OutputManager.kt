package racingcar

class OutputManager {
    fun printRaceStartMessage() {
        println("\n" + EXECUTION_RESULT_MESSAGE)
    }

    fun printWinners(winnerCarNames: List<String>) {
        println(INITIAL_WINNER_NAME_MESSAGE + winnerCarNames.joinToString(", "))
    }

    companion object {
        private const val EXECUTION_RESULT_MESSAGE = "실행 결과"
        private const val INITIAL_WINNER_NAME_MESSAGE = "최종 우승자 : "
    }
}