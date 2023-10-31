package view

object GameConsole {

    private const val MESSAGE_ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val MESSAGE_ASK_MOVE_COUNT = "시도할 횟수는 몇 회인가요?"
    private const val MESSAGE_FINAL_WINNER = "최종 우승자 : "
    private const val PROGRESS_BAR = "-"
    private const val CAR_NAME_SEPARATOR = ", "

    fun printPosition(name: String, position: Int) {
        println("$name : ${PROGRESS_BAR.repeat(position)}")
    }

    fun printWinnerNames(winnerNames: List<String>) {
        val winner = winnerNames.joinToString(CAR_NAME_SEPARATOR)
        println(MESSAGE_FINAL_WINNER + winner)
    }

    fun printCarNamePrompt() {
        println(MESSAGE_ASK_CAR_NAME)
    }

    fun printMoveCountPrompt() {
        println(MESSAGE_ASK_MOVE_COUNT)
    }
}