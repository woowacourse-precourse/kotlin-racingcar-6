package racingcar

import kotlin.random.Random

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = readLine()
    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("올바른 숫자를 입력하세요.")

    val cars = carNames?.split(",")?.map { Car(it.trim()) }
        ?: throw IllegalArgumentException("올바른 자동차 이름을 입력하세요.")

    race(cars, tryCount)
}

data class Car(val name: String, var position: Int = 0)

fun race(cars: List<Car>, tryCount: Int) {
    repeat(tryCount) {
        println("\n시도 ${it + 1}")
        cars.forEach { car ->

            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    val maxPosition = cars.map { it.position }.maxOrNull()
    val winners = cars.filter { it.position == maxPosition }.map { it.name }

    println("\n최종 우승자 : ${winners.joinToString(", ")}")
}


