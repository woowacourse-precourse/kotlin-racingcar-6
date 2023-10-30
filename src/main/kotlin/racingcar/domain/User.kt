package racingcar.domain

import camp.nextstep.edu.missionutils.Console

class User {

    fun namingCar(): Map<String, Int> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carsName: String = Console.readLine()
        return carsName.split(",").map { it }.associateWith { 0 }
    }

    fun attemptNumber(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toInt()
    }
}