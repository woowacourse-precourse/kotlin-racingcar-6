package racingcar

import camp.nextstep.edu.missionutils.Console
class Game {
    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val inputString = Console.readLine()
        val names = inputString.split(",").map{ it.trim() }
        val cars: List<Car> = names.map{ Car(it) }
    }
}

class Car(val name: String) {
    var location: Int = 0
    fun randMove(): Unit = TODO()
}