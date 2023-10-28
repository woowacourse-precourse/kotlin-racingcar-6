package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car

private var carNames: MutableList<Car> = mutableListOf()
private var highScore: Int = 0
fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    askCarName(Console.readLine())
    println("시도할 횟수는 몇 회인가요?")
    val count = askNumber(Console.readLine())
    for (i in 1..count) {
        playRound()
    }
    printWinner()
}

fun playRound() {
    carNames.all {
        it.move()
        it.printResult()
        if (it.getDistance() > highScore) highScore = it.getDistance()
        true
    }
}

fun askCarName(input: String) {
    val carNameList = input.split(",")
    for (carName in carNameList) {
        if (carName.length > 5) throw IllegalArgumentException("String index out of range: 5")
        carNames.add(Car(carName))
    }
}

fun askNumber(count: String): Int {
    return count.toIntOrNull() ?: throw IllegalArgumentException("Input is not Int")
}

fun printWinner() {
    var isFirst = true
    print("최종 우승자 : ")
    carNames.all {
        isFirst = decideWinner(it, isFirst)
        true
    }
    println()
}

fun decideWinner(car: Car, isFirst: Boolean): Boolean {
    if (car.getDistance() == highScore) {
        val name = car.name
        if (isFirst) {
            print(name)
            return false
        }
        print(", $name")
        return false
    }
    return isFirst
}
