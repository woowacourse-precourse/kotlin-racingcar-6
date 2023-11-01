package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val cars = enterCarName()
    val numberAttempt = enterNumberAttempts()
    result(cars, numberAttempt)
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
        if(numberAttempt.length == 1 && i == '0') throw IllegalArgumentException("0번 시도할 수는 없습니다.")
        if (i < '0' || i > '9') throw IllegalArgumentException("숫자만 입력해주세요.")
    }
}

fun result(cars: List<String>, numberAttempt: String) {
    println("실행 결과")
    val raceProgress = MutableList(cars.size) { "" }
    repeat(numberAttempt.toInt()) {
        printEachResult(cars, raceProgress)
    }
}

fun printEachResult(
    cars: List<String>,
    raceProgress: MutableList<String>
) {
    for (i in cars.indices) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            raceProgress[i] += "-"
        }
    }

    for (i in cars.indices) {
        println("${cars[i]} : ${raceProgress[i]}")
    }
    println()
    guideWinners(cars, raceProgress)
}

fun guideWinners(cars: List<String>, raceProgress: MutableList<String>) {
    val max = raceProgress.maxByOrNull { it.length }?.length ?: 0
    val winner = mutableListOf<String>()
    for (i in raceProgress.indices) {
        if (raceProgress[i].length == max) {
            winner.add(cars[i])
        }
    }
    println("최종 우승자 : ${winner.joinToString(", ")}")
}