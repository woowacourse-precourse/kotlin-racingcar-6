package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val cars = enterCarName()
}

fun enterCarName(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = Console.readLine().split(",")
    validationCarName(cars)
    return cars
}

fun validationCarName(cars: List<String>) {
    for (car in cars) {
        if (car.length > 5) throw IllegalArgumentException("5자 이하만 가능합니다.")
    }
}