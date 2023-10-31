package racingcar.views

class OutputView {

    companion object {
        const val NO_CAR_NAME_ERROR = "자동차 이름을 반드시 입력해야 합니다."
        const val CAR_NAME_COUNT_ERROR = "자동차 이름은 5자 이하로만 가능합니다."
        const val NO_ALL_CAR_NAME_ERROR = "자동차 이름은 모두 필수로 입력해야 합니다."
        const val DUPLICATE_CAR_NAME_ERROR = "자동차 이름은 중복하지 않아야 합니다."
        const val CAR_COUNT_ERROR = "게임에 참여 가능한 자동차 대수는 1대 이상 7대 이하만 가능합니다."
        const val NO_TRY_COUNT_ERROR = "시도할 횟수를 반드시 입력해야 합니다."
        const val NOT_DIGIT_TRY_COUNT_ERROR = "시도할 횟수는 숫자(1 ~ 10)로만 입력 가능합니다."
        const val TRY_COUNT_RANGE_ERROR = "시도할 횟수는 1부터 10 사이로만 입력 가능합니다."
        const val SOLO_GAME_RULE = "단독 출전 시 2번 게임 진행 후 1회 이상 전진 시 우승입니다."
        const val RESULT_MESSAGE = "실행 결과"
        const val WINNER_MESSAGE = "최종 우승자 : "
        const val NO_WINNER_MESSAGE = "우승자가 없습니다."
    }

    fun printSoloGameRules() {
        skipLine()
        println(SOLO_GAME_RULE)
    }

    fun printSoloGameResult(inputCarName: String, forward: String) {
        printResultForm(inputCarName, forward)
        skipLine()
    }

    fun printMultiGameResult(multiCarName: List<String?>, scoreMap: Map<String, Int>) {
        for (carName in multiCarName) {
            val score = scoreMap.getOrDefault(carName, 0)
            val forward = "-".repeat(score)
            printResultForm(carName!!, forward)
        }
        skipLine()
    }

    private fun printResultForm(carName: String, forward: String) {
        println("$carName : $forward")
    }

    fun printResultMessage() {
        skipLine()
        println(RESULT_MESSAGE)
    }

    fun printSoloWinner(carName: String) {
        println(WINNER_MESSAGE + carName)
    }

    fun printMultiWinner(winners: Set<String>) {
        println(WINNER_MESSAGE + { winners.joinToString(",") })
    }

    fun printNoWinner() {
        println(NO_WINNER_MESSAGE)
    }

    private fun skipLine() {
        println("")
    }
}
