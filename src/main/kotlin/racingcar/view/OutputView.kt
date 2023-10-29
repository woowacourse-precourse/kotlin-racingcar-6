package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    private val move = "-"

    // 기능 8. 실행 결과 출력하기
    fun printAttemptResult(racingCarList: List<RacingCar>) {
        for (racingCar in racingCarList) {
            printRacingCarMove(racingCar)
        }
        println()
    }

    fun printWinner(winnerList: List<RacingCar>) {
        val winnerNameList = winnerList.joinToString(", ") { winner -> winner.carName }
        println("최종 우승자 : $winnerNameList")
    }

    fun printRacingCarMove(racingCar: RacingCar) {
        println("${racingCar.carName} : " + move.repeat(racingCar.totalMove))
    }

    fun printResultHeader() {
        println()
        println("실행 결과")
    }

    fun printRacingCarNameInstruction() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printAttemptNumberInstruction() {
        println("시도할 횟수는 몇 회인가요?")
    }
}