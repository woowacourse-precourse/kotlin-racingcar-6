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
}