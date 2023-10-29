package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    private val move = "-"

    // 기능 8. 실행 결과 출력하기
    fun printAttemptResult(attemptNumber: Int, racingCarList: List<RacingCar>) {
        if (attemptNumber == 0) {
            printResultHeader()
        }

        for (racingCar in racingCarList) {
            printRacingCarMove(racingCar)
        }
        println()
    }

    // 기능 9. 우승자 안내하기분
    fun printWinner(racingCarList: List<RacingCar>) {
        var maxMove = 0

        for (racingCar in racingCarList) {
            if (racingCar.totalMove > maxMove) {
                maxMove = racingCar.totalMove
            }
        }

        val winnerList = mutableListOf<String>()

        for (racingCar in racingCarList) {
            if (racingCar.totalMove == maxMove) {
                winnerList.add(racingCar.carName)
            }
        }

        println("최종 우승자 : ${winnerList.joinToString(", ")}")
    }

    fun printRacingCarMove(racingCar: RacingCar) {
        println("${racingCar.carName} : " + move.repeat(racingCar.totalMove))
    }

    fun printResultHeader() {
        println()
        println("실행 결과")
    }

    fun printRacingCarNameInstructions() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printAttemptNumberInstruction() {
        println("시도할 횟수는 몇 회인가요?")
    }
}