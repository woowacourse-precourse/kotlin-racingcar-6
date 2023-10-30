package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startRacingGame()
}

fun startRacingGame() {
    val cars = carNamesInput()

    var raceRound = roundInput()

    raceRound = roundResult(raceRound, cars)

    printWinners(raceRound, cars)
}

fun carNamesInput(): List<Cars> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)")
    val carNames = Console.readLine()
    val cars = carNames.split(',').map { Cars(it) }
    validateCarNames(cars)
    return cars
}

fun validateCarNames(cars: List<Cars>) {
    if (cars.any { it.name.length > 5 }) {
        throw IllegalArgumentException("5글자 이하로 이름을 지어주세요")
    }
}

fun roundInput(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val raceRound = Console.readLine().toInt()
    validateRaceRound(raceRound)
    return raceRound
}

fun validateRaceRound(raceRound: Int) {
    if (raceRound <= 0) {
        throw IllegalArgumentException("자연수로 입력해주세요")
    }
}

fun roundResult(inputRound: Int, cars: List<Cars>): Int {
    var raceRound = inputRound
    println("\n실행 결과")
    while (raceRound > 0) {
        cars.forEach { car ->
            car.move()
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
        raceRound--
    }
    return raceRound
}

fun printWinners(raceRound: Int, cars: List<Cars>) {
    val winners = if (raceRound == 0) {
        val headPosition = cars.maxOf { it.position }
        cars.filter { it.position == headPosition }.map { it.name }
    } else {
        mutableListOf()
    }
    println("최종 우승자 : ${winners.joinToString(", ")}")
}

class Cars(carName: String) {
    var position = 0
    val name = carName

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
}