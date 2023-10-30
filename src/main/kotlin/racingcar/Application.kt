package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var position: Int = 0){
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val names = readCarNames()

    println("시도할 횟수는 몇 회인가요?")
    val numberOfMoves = readNumberOfMoves()

    val cars = createCars(names)
    runRace(cars, numberOfMoves)
}

// 사용자로부터 자동차 이름들을 입력받는 함수
fun readCarNames(): List<String> {
    val names = Console.readLine().split(",")
    validateCarNames(names)
    return names
}

// 자동차 이름들의 유효성 검사를 수행하는 함수
fun validateCarNames(names: List<String>) {
    for (name in names) {
        if (name.length > 5) { // 각 이름이 5자를 초과하면 예외 발생
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
        if (name.isBlank()) { // 빈 문자열이나 공백 문자열일 경우 예외 발생
            throw IllegalArgumentException("자동차 이름은 공백일 수 없습니다.")
        }
    }
}

// 사용자로부터 이동 횟수를 입력받는 함수
fun readNumberOfMoves(): Int {
    val input = Console.readLine()
    validateMoveCountInput(input)
    return input.toInt()
}

// 이동 횟수의 유효성 검사를 수행하는 함수
fun validateMoveCountInput(input: String) {
    if (!input.matches(Regex("\\d+"))) { // 숫자만 포함되어 있는지 확인
        throw IllegalArgumentException("이동 횟수는 숫자만 가능합니다.")
    }
}

// 자동차 객체들을 생성하는 함수
fun createCars(names: List<String>): List<Car> {
    return names.map { Car(it) }
}
// 경주 실행 함수
fun runRace(cars: List<Car>, numberOfMoves: Int) {
    repeat(numberOfMoves) {
        cars.forEach { it.move() }
        printCurrentPositions(cars)
    }
}

// 현재 위치 출력 함수
fun printCurrentPositions(cars: List<Car>) {
    cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
    println()
}