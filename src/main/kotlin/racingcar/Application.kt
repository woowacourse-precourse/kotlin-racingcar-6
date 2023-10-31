package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val input = getCarsName()
    val cars = generateCarsFromInput(input)

    val turn = getTurnNumber()

    playRaceGame(turn, cars)

    val winners = findWinners(cars)
    val winnersName = createWinnersName(winners)
    announceWinners(winnersName)
}

fun announceWinners(winnersName: String) {
    println("최종 우승자 : $winnersName")
}

fun createWinnersName(winners: List<Car>) = winners.joinToString(", ") { it.name }

fun findWinners(cars: List<Car>): List<Car> {
    val maxPosition = cars.maxOf { car ->
        car.position
    }
    val winners = cars.filter { car ->
        car.position == maxPosition
    }
    return winners
}

fun playRaceGame(turn: Int, cars: List<Car>) {
    println("실행 결과")
    repeat(turn) {
        moveCarsForwardIfCan(cars)
        printCarsInEachStep(cars)
    }
}

fun printCarsInEachStep(cars: List<Car>) {
    cars.forEach { car ->
        println(car)
    }
    println()
}

fun moveCarsForwardIfCan(cars: List<Car>) {
    cars.forEach { car ->
        moveCarForwardIfCan(car)
    }
}

fun moveCarForwardIfCan(car: Car) {
    if (canCarMoveForward()) {
        car.moveForward()
    }
}

fun canCarMoveForward(): Boolean {
    return Randoms.pickNumberInRange(0, 9) >= 4
}

fun getTurnNumber(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return try {
        Console.readLine().toInt()
    } catch (e: NumberFormatException) {
        e.printStackTrace()
        GameUtils.onWrongInput()
    }
}

fun generateCarsFromInput(input: String): List<Car> {
    val tokens = input.split(",")
    val cars = tokens.map { token ->
        generateCarFromToken(token)
    }
    return cars
}

fun generateCarFromToken(token: String): Car {
    GameUtils.checkValidInput {
        token.length <= 5
    }
    return Car(token)
}

fun getCarsName(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    GameUtils.checkValidInput { input != null }
    return input
}