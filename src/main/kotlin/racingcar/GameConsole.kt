package racingcar

object GameConsole {

    fun printPosition(name: String, position: Int) {
        println("$name : ${Constants.PROGRESS_BAR.repeat(position)}")
    }

    fun printWinnerNames(winnerNames: List<String>) {
        val winner = winnerNames.joinToString(Constants.CAR_NAME_SEPARATOR)
        println(Constants.MESSAGE_FINAL_WINNER + winner)
    }
}