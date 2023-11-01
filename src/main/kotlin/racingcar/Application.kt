package racingcar

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.util.Maps


fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input: String = readLine() ?: throw IllegalArgumentException()
    val cars = input.split(',')
    if (!cars.all { it.length <= 5 }) {
        throw IllegalArgumentException()
    }
    val carMap = cars.associateWith { 0 }.toMutableMap()

    val keys = carMap.keys
    println("시도할 횟수는 몇 회인가요?")
    val tries: Int = readLine()?.toInt() ?: throw IllegalArgumentException()

    println("\n")
    println("실행 결과")

    for (i in 1..tries) {
        for (key in keys) {
            carMoveCounter(key, carMap)
        }
        for (key in keys) {
            printMove(key, carMap)
        }
        print("\n")
    }

    val winners: Map<String, Int> = winner(carMap)
    println("최종 우승자 : ${winners.keys.joinToString()}")
}

fun moveCondition(): Boolean {
    val num = Randoms.pickNumberInRange(0, 9)

    if (num < 4) return false
    else return true
}

fun carMoveCounter(key: String, carMap: MutableMap<String, Int>) {
    if (moveCondition()) carMap[key] = (carMap[key] ?: 0) + 1
}

fun printMove(key: String, carMap: MutableMap<String, Int>) {
    val moveDistance = carMap[key] ?: throw IllegalArgumentException()

    print("${key} : ")
    for (i in 1..moveDistance) {
        print("-")
    }
    print("\n")
}

fun winner(carMap: MutableMap<String, Int>): Map<String, Int> {
    val maxCount = carMap.values.maxOrNull() ?: emptyMap<String, Int>()
    return carMap.filter { it.value == maxCount }
}