package racingcar

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.util.Maps


fun main() {
    // TODO : 자동차 이름 입력받기 (,로 구분)
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input: String = readLine() ?: throw IllegalArgumentException()
    val cars = input.split(',')
    val carMap = cars.associateWith { 0 }.toMutableMap()

    println(carMap)
    val keys = carMap.keys
    // TODO : 시도할 횟수 입력받기
    println("시도할 횟수는 몇 회인가요?")
    val tries: Int = readLine()?.toInt() ?: throw IllegalArgumentException()

    println(tries)

    for (i in 1..tries) {
        for (key in keys) {
            carMoveCounter(key, carMap)
        }
        println(carMap)
    }
    // TODO : 최종결과 출력하는 함수 만들기
}

fun moveCondition(): Boolean {
    // TODO : 전진 조건 판별하는 함수 만들기
    val num = Randoms.pickNumberInRange(0, 9)
    println(num)

    if (num < 4) return false
    else return true
}

fun carMoveCounter(key: String, carMap: MutableMap<String, Int>) {
    println(key)
    if (moveCondition()) carMap[key] = (carMap[key] ?: 0) + 1
}

