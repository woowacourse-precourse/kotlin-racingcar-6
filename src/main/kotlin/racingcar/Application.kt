package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


data class Car(val name: String, var position: String="")

fun main() {
    val cars = inputCarNames()
    val numberOfMoves = inputNumberOfMoves()
    println("\n실행 결과")
    race(cars, numberOfMoves)


    val winners = findWinners(cars)
    displayWinners(winners)
}

fun inputCarNames(): List<Car> { //자동차 이름 입력받기
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    val carNames = input.split(",").map { it.trim() }
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException()
    }
    return carNames.map { Car(it) }
}

fun inputNumberOfMoves(): Int { //이동 횟수 입력
    println("시도할 횟수는 몇 회인가요?")
    val input = Console.readLine()
    val numberOfMoves = input.toIntOrNull()

    if (numberOfMoves == null || numberOfMoves <= 0) {
        throw IllegalArgumentException()
    }

    return numberOfMoves
}
fun move(car: Car) { //자동차 0~9랜덤 추출 후 4이상이면 포지션 증가
    val randomValue = Randoms.pickNumberInRange(0, 9)

    if (randomValue >= 4) {
        car.position+='-'
    }
}

fun race(cars: List<Car>, numberOfMoves: Int) {  //횟수만큼 moving 함수 실행
    repeat(numberOfMoves) {
        moving(cars)
        printRace(cars)
    }
}
fun moving(cars: List<Car>){  //cars배열 속 하나하나 move함수 실행
    for (car in cars) {
        move(car)
    }
}

fun printRace(cars: List<Car>){ //레이스 하는 과정 print
    for (car in cars) {
        println("${car.name} : ${car.position}")
    }
    println("")
}

fun findWinners(cars: List<Car>): List<String> { //우승자 검색
    val maxPosition = cars.map { it.position }.maxOrNull()
    return cars.filter { it.position == maxPosition }.map { it.name }
}

fun displayWinners(winners: List<String>) { //최종 우승자 출력
    print("최종 우승자 : ${winners.joinToString(", ")}")
}