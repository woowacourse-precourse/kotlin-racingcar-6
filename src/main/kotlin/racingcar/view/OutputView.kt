package racingcar.view

class OutputView {

    enum class Message(val text: String) {
        RESULT_WINNER("최종 우승자 : %s"),
        INPUT_GUIDE_CAR_NAME_LIST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_GUIDE_PLAY_COUNT("시도할 횟수는 몇 회인가요?"),
        PLAY_RESULT("실행 결과")
    }

    fun printMessage(message: String) = println(message)
    fun printInputGuideCarNameList() = printMessage(Message.INPUT_GUIDE_CAR_NAME_LIST.text)
    fun printInputGuidePlayCount() = printMessage(Message.INPUT_GUIDE_PLAY_COUNT.text)
    fun printResultMessage() = printMessage(Message.PLAY_RESULT.text)
    fun printPlayStatus(playStatus: String) = printMessage(playStatus)
    fun printResultWinner(winnerList: List<String>) {
        val winnerString = winnerList.joinToString(", ")
        printMessage(Message.RESULT_WINNER.text.format(winnerString))
    }
}