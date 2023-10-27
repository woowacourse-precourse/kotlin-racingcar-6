package racingcar

import camp.nextstep.edu.missionutils.Console

class View {
    fun enterNames(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return Console.readLine()
    }

    fun enterNumberTimes(): String {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine()
    }

    fun printPosition(cars: List<Car>) {
        println("실행 결과")
        for (i in cars) {
            println("${i.getName()} : ${i.getPosition()}")
        }
    }

    fun printWinner(winnerList: List<String>) {
        print("최종 우승자 : ")
        val winner = winnerList.joinToString(", ")
        print(winner)
    }
}