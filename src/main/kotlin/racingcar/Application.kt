package racingcar

import kotlin.random.Random

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = readLine()
    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("올바른 숫자를 입력하세요.")

    val cars = carNames?.split(",")?.map { Car(it.trim()) }
        ?: throw IllegalArgumentException("올바른 자동차 이름을 입력하세요.")

}
