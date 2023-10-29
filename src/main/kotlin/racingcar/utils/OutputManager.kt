package racingcar.utils

class OutputManager {

    fun printRaceResult() {
        println()
        println(Constants.EXECUTION_RESULT_MESSAGE)
    }

    fun printWinners(winnerCarNames: MutableList<String>) {
        println(Constants.INITIAL_WINNER_NAME_MESSAGE + winnerCarNames.joinToString(","))
    }
}