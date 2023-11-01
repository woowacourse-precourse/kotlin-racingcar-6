package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
class Car(val name: String) {
    var position = 0

    init {
        require(name.isNotBlank() && name.length <= 5) { throw IllegalArgumentException("잘못된 이름입니다.") }
    }

    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            position++
        }
    }

    fun printPosition() {
        print("$name : ")
        repeat(position) {
            print("-")
        }
        println()
    }
}
fun Car.move() {
    val randomNumber = Randoms.pickNumberInRange(0, 9)
    if (randomNumber >= 4) {
        position++
    }
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine()

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = Console.readLine().toIntOrNull()

    println("\n실행 결과")

    //입력 유효성 검사 구현 IllegalArgumentException 예외 발생
    require(carNames != null && tryCount != null && tryCount > 0) { throw IllegalArgumentException("잘못된 입력입니다.") }

    val carNameList = carNames.split(",")

    val cars = carNameList.map { Car(it.trim()) }

    repeat(tryCount) {
        cars.forEach { it.move() }
        cars.forEach { it.printPosition() }
        println()
    }

    //최종 우승자 결정 및 발표 로직
    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.map { it.name }

    println("최종 우승자 : ${winners.joinToString(", ")}")
}