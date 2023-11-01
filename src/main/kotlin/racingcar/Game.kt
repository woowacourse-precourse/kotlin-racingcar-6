package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Game {
    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val inputString = Console.readLine()
        val names = inputString.split(",").map { it.trim() }
        val cars: List<Car> = names.map { Car(it) }
        println("시도할 횟수는 몇 회인가요?")
        val loopCount = Console.readLine().trim().toInt()
        println("실행 결과")
        cars.race(loopCount)
        print("최종 우승자 : ")
        println(cars.winner())
    }
}

fun List<Car>.toStatusString(): String {
    val progressCharacter = "-"
    return this.map { "${it.name} : ${progressCharacter.repeat(it.location)}" }
        .joinToString(separator = "\n", postfix = "\n")
}

fun List<Car>.race(loopCount: Int): Unit {
    for (i in 1..loopCount) {
        this.forEach { it.randMove() }
        println(this.toStatusString())
    }
}

fun List<Car>.winner(): String {
    val maxLocation = this.maxOf { it.location }
    val winners = this.filter { it.location == maxLocation }
    return winners.map { it.name }.joinToString(", ")
}

class Car(val name: String) {
    init {
        if (name.length > 5) throw IllegalArgumentException("5자 이상 이름 필요")
    }

    var location: Int = 0
    fun randMove(): Unit {
        if (Randoms.pickNumberInRange(0, 9) >= 4) location++
    }
}