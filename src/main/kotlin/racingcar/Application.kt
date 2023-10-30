package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carName = readLine()?.split(",") ?: throw IllegalArgumentException("올바르게 다시 입력해주세요")

    for (car in carName) {
        if (car.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
    }
    println("시도할 횟수는 몇 회인가요?")
    val tryCountInput = readLine()!!.toInt()
    if (tryCountInput <= 0) {
        throw IllegalArgumentException("시도 횟수는 0보다 커야 합니다.")
    }
    val carMove = mutableMapOf<String, Int>()

    for (i in 1..tryCountInput) {
        println()
        for (car in carName) {
            if ((0..9).random() >= 4) {
                carMove[car] = (carMove[car] ?: 0) + 1
            }
        }
        for (car in carName) {
            val distance = carMove[car] ?: 0
            println("$car : ${"-".repeat(distance)}")
        }
    }

}