package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    startRacingGame()
}

fun startRacingGame() {
    val cars = carNamesInput()

    val raceRound = roundInput()

    gameResult(raceRound, cars)
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

fun gameResult(inputRound: Int, cars: List<Cars>) {
    println("\n실행 결과")
    val racedCars = raceCars(inputRound, cars)
    raceCars(inputRound, cars)
    printWinners(getWinners(racedCars))
}

fun raceCars(inputRound: Int, cars: List<Cars>): List<Cars> {
    repeat(inputRound) {
        cars.forEach { it.move() }
        printCarPositions(cars)
        println()
    }
    return cars
}

fun printCarPositions(cars: List<Cars>) {
    cars.forEach { car ->
        println("${car.name} : ${"-".repeat(car.position)}")
    }
}

fun getWinners(cars: List<Cars>): List<Cars>{
    val headPosition = cars.maxOf { it.position }
    return cars.filter { it.position == headPosition }
}

fun printWinners(winners: List<Cars>) {
    val winnersName = winners.map { it.name }
    println("최종 우승자 : ${winnersName.joinToString(", ")}")
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