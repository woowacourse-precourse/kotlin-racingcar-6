package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val cars = enterCarName()
    val numberAttempt = enterNumberAttempts()
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

    val deduplicationSize = cars.distinct().size
    if (cars.size != deduplicationSize) throw IllegalArgumentException("중복된 이름은 사용할 수 없습니다.")
}

fun enterNumberAttempts(): String {
    println("시도할 횟수는 몇 회인가요?")
    val numberAttempt = Console.readLine()
    validationNumberAttempts(numberAttempt)
    return numberAttempt
}

fun validationNumberAttempts(numberAttempt: String) {
    for (i in numberAttempt) {
        if (i < '0' || i > '9') throw IllegalArgumentException("숫자만 입력해주세요.")
    }
}