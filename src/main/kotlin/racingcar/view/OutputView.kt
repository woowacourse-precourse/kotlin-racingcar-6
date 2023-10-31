package racingcar.view

import racingcar.model.Car

class OutputView {
    companion object {
        private const val MOVE = "-"
        private const val WINNER_LIST_MENTION = "최종 우승자 : "
        private const val EXECUTION_RESULT_MENTION = "실행 결과"
        private const val NAME_INPUT_GUIDE_MENTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val ROUND_NUMBER_INPUT_GUIDE_MENTION = "시도할 횟수는 몇 회인가요?"
    }
    fun printResult(carList: List<Car>) {
        for (car in carList) {
            printCurrentPosition(car)
        }
        println()
    }

    fun printWinner(winnerList: List<Car>) {
        val winnerNameList = winnerList.joinToString(", ") { winner -> winner.name }
        println("$WINNER_LIST_MENTION$winnerNameList")
    }

    fun printResultMention() {
        println()
        println(EXECUTION_RESULT_MENTION)
    }

    fun printCarNameInputMention() {
        println(NAME_INPUT_GUIDE_MENTION)
    }

    fun printRoundNumberInputMention() {
        println(ROUND_NUMBER_INPUT_GUIDE_MENTION)
    }

    private fun printCurrentPosition(car: Car) {
        println("${car.name} : " + MOVE.repeat(car.moves))
    }
}