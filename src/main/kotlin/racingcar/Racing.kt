package racingcar

import camp.nextstep.edu.missionutils.Console

class Racing {

    fun ready() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        RacingSystem.setCarNames(Console.readLine())
        println("시도할 횟수는 몇 회인가요?")
        RacingSystem.setAttemptNumber(Console.readLine())
        RacingSystem.createCarLane()
    }

    fun start() {
        RacingSystem.startAttemptCarLane()
    }

    fun presentWinner() {
        val winners = RacingSystem.getWinners().joinToString(separator = ", ")
        println("\n최종 우승자 : $winners")
    }
}