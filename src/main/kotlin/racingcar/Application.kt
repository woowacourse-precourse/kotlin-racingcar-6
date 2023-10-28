package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main() {

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val names = Console.readLine().split(",").map {
        if (it.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
        it
    }

    println("시도할 횟수는 몇 회인가요?")
    val attempts = Console.readLine().toInt()

    val cars = names.map { Car(it) }

    val racing = Racing(cars, attempts)

    racing.start()

}

class Car(name: String, var position: Int = 0) {

    val name = name

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

}

class Racing(val cars: List<Car>, attempts: Int) {
    val attempts = attempts.also {
        if (it < 0) throw IllegalArgumentException("시도할 횟수는 0 이상이어야 합니다.")
    }

    fun start() {
        for (i in 0 until attempts) {
            cars.forEach { it.move() }
            printResult()
        }
    }

    fun printResult() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

}