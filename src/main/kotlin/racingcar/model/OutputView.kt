package racingcar.model

class OutputView {
    companion object {
        private const val MOVE = "-"
    }
    fun printResult(racingCarList: List<RacingCar>) {
        for (car in racingCarList) {
            printCurrentMove(car)
        }
        println()
    }

    fun printWinner(winnerList: List<RacingCar>) {
        val winnerNameList = winnerList.joinToString(", ") { winner -> winner.name }
        println("최종 우승자 : $winnerNameList")
    }

    fun printResultMention() {
        println()
        println("실행 결과")
    }

    fun printCarNameInputMention() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printRoundNumberInputMention() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printCurrentMove(racingCar: RacingCar) {
        println("${racingCar.name} : " + MOVE.repeat(racingCar.moves))
    }
}