package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine()!!.split(",")
    if (!isCarNamesValid(carNames)) {
        throw IllegalArgumentException("자동차 이름은 5자 이하만 가능하며, 쉼표(,)로 구분되어야 합니다.")
    }

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = Console.readLine()!!.toInt()
    if (tryCount <= 0) {
        throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
    }

    val cars = carNames.map { Car(it) }

    println("\n실행 결과")
    repeat(tryCount) {
        cars.forEach { it.move(Randoms.pickNumberInRange(0, 9)) }
        println()
    }

    val winners = cars.filter { it.position == cars.maxOf { car -> car.position } }
    println("최종 우승자 : ${winners.joinToString(", ") { it.name }}")
}

class Car(val name: String) {
    var position = 0
        private set

    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            position++
        }
        print("$name : ")
        println("-".repeat(position))

    }
}

fun isCarNamesValid(carNames: List<String>): Boolean {
    return carNames.all { it.length <= 5 }
}
