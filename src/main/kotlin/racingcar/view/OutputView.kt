package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    private val step = "-"

    // 기능 8. 실행 결과 출력하기
    fun printResult(tryNumber: Int, racingCarList: List<RacingCar>) {
        if (tryNumber == 0) {
            println("\n실행 결과")
        }

        for (racingCar in racingCarList) {
            printMoveOfRacingCar(racingCar)
        }
        println()
    }

    // 기능 9. 우승자 안내하기분
    fun printWinners(racingCarList: List<RacingCar>) {
        var maxNumberOfMove = 0

        for (racingCar in racingCarList) {
            if (racingCar.numberOfMove > maxNumberOfMove) {
                maxNumberOfMove = racingCar.numberOfMove
            }
        }

        val winners = mutableListOf<String>()

        for (racingCar in racingCarList) {
            if (racingCar.numberOfMove == maxNumberOfMove) {
                winners.add(racingCar.name)
            }
        }

        println("최종 우승자 : ${winners.joinToString(", ")}")
    }

    fun printMoveOfRacingCar(racingCar: RacingCar) {
        println("${racingCar.name} : " + step.repeat(racingCar.numberOfMove))
    }

    fun printInstructionForRacingCarName() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printInstructionForTryNumber() {
        println("시도할 횟수는 몇 회인가요?")
    }
}