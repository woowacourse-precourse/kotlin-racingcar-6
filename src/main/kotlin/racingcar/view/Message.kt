package racingcar.view

import racingcar.model.RacingCar
import racingcar.util.Util

class Message {

    //자동차 이름을 요청
    fun requestCarNames() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    //시도할 횟수를 요청
    fun requestPlayCount() {
        println("시도할 횟수는 몇 회인가요?")
    }

    //실행 결과
    fun executionResult() {
        println("실행 결과")
    }

    //게임의 진행상황
    fun progress(cars: MutableList<RacingCar>) {

        for (car in cars) {
            println("${car.name} : ${"-".repeat(car.forwardCount)}")
        }
        println()
    }

    //게임이 종료후 최종 우승 결과
    fun winner(cars: MutableList<RacingCar>) {
        val winners = Util.findWinner(cars)

        print("최종 우승자 : ")

        winners.forEachIndexed { index, winner ->
            if (index != winners.lastIndex) {
                print("${winner.name}, ")
            }
            if (index == winners.lastIndex) {
                print(winner.name)
            }
        }
    }


}