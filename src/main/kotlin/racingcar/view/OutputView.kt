package racingcar.view

class OutputView {
    companion object {
        private const val RESULT_WINNER_MESSAGE = "최종 우승자 : %s"
        private const val INPUT_GUIDE_CAR_NAME_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val INPUT_GUIDE_PLAY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val PLAY_RESULT_MESSAGE = "\n실행 결과"
    }

    private fun printMessage(message: String) = println(message)
    fun printInputGuideCarNameList() = printMessage(INPUT_GUIDE_CAR_NAME_LIST_MESSAGE)
    fun printInputGuidePlayCount() = printMessage(INPUT_GUIDE_PLAY_COUNT_MESSAGE)
    fun printResultMessage() = printMessage(PLAY_RESULT_MESSAGE)
    fun printPlayResult(playResult: String) = printMessage(playResult)
    fun printResultWinner(winnerList: List<String>) {
        val winnerString = winnerList.joinToString(", ")
        printMessage(RESULT_WINNER_MESSAGE.format(winnerString))
    }
}