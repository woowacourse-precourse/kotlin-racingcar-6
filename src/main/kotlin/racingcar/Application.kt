package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val carNames = getCarNames()
    println("시도할 횟수는 몇 회인가요?")

    val tryCount = getTryCount()
    val cars = carNames.map { Car(it.toString()) }

    racestart(tryCount, cars)
    printResult(cars)

}

fun getCarNames(): List<String>{
    val inputCarName = Console.readLine()
    val listNameInput = inputCarName?.split(",")

    checkNameInput(listNameInput?: emptyList())
    return listNameInput?: emptyList()
}

fun checkNameInput(listNameInput: List<String>): List<String> {
    if ( listNameInput.any { it.length > 5} ) {
        throw IllegalArgumentException("차 이름은 5자 이하여야 합니다.")
    }
    return listNameInput
}

fun getTryCount(): Int {
    val inputTryCount = Console.readLine()
    try{
        return inputTryCount?.toInt()?: 0
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
    }
}

class Car (val name: String) {
    var position = 0;

    fun advance() {
        if (Randoms.pickNumberInRange(0, 9) > 5) {
            position++
        }
    }

}

fun racestart(tryCount: Int, cars: List<Car>) {
    println("\n실행 결과")

    for (i in 0 until tryCount) {
        for (car in cars) {
            car.advance()
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println("\n")
    }

}


fun printResult(cars: List<Car>) {
    val maxPosition = cars.map { it.position }.maxOrNull()
    val winners = cars.filter { it.position == maxPosition }
    val winnerNames = winners.joinToString(", ") { it.name }

    if (winners.size == 1) {
        println("\n최종 우승자: $winnerNames")
    } else {
        println("\n공동 우승자: $winnerNames")
    }
}