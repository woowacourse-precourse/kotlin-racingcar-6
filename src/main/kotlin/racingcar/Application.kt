package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val cars = enterCarName()
    val numberAttempt = enterNumberAttempts()
    result(cars, numberAttempt)
}

fun enterCarName(): List<Car> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carsName = Console.readLine().split(",")
    validationCarName(carsName)
    val cars = mutableListOf<Car>()
    for (carName in carsName) {
        cars.add(Car(carName))
    }
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
        if (numberAttempt.length == 1 && i == '0') throw IllegalArgumentException("0번 시도할 수는 없습니다.")
        if (i < '0' || i > '9') throw IllegalArgumentException("숫자만 입력해주세요.")
    }
}

fun result(cars: List<Car>, numberAttempt: String) {
    println()
    println("실행 결과")
    repeat(numberAttempt.toInt()) {
        printEachResult(cars)
    }
    guideWinners(cars)
}

fun printEachResult(
    cars: List<Car>
) {
    for (i in cars.indices) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            cars[i].move()
        }
    }

    for (i in cars.indices) {
        println("${cars[i].name} : ${cars[i].raceProgress}")
    }
    println()
}

fun guideWinners(cars: List<Car>) {
    val max = cars.maxOfOrNull { it.raceProgress }?.length ?: 0
    val winner = mutableListOf<String>()
    for (i in cars.indices) {
        if (cars[i].isWinner(max)) {
            winner.add(cars[i].name)
        }
    }
    println("최종 우승자 : ${winner.joinToString(", ")}")
}