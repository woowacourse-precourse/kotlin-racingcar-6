package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

val CARS = mutableListOf<Car>()
val CARSNAME = mutableListOf<String>()
val WINNERS = mutableListOf<String>()
var MAX = 0

fun main() {
    clear()
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    input()
    val repeat = inputRepeat()
    for(i in CARSNAME){
        CARS.add(Car(i))
    }
    processGame(repeat)
    findMaxPos()
    winner()
}
fun clear(){
    CARS.clear()
    WINNERS.clear()
    MAX = 0
    CARSNAME.clear()
}
private fun winner() {
    for (car in CARS) {
        if (car.position == MAX) {
            WINNERS.add(car.name)
        }
    }
    printWinner(WINNERS)
}

private fun findMaxPos() {
    for (car in CARS) {
        if (car.position >= MAX) {
            MAX = car.position
        }
    }
}
private fun printWinner(winners: MutableList<String>) {
    print("최종 우승자 : ${winners.joinToString(", ")}")
}
private fun processGame(repeat: Int) {
    println()
    println("실행 결과")
    for(i in 0 until repeat){
        gamePlay()
    }
}
fun gamePlay(){
    for(car in CARS){
        var random = Randoms.pickNumberInRange(0, 9)
        step(random,car)
    }
    println()
}
fun step(random: Int, car: Car) {
    if(random >= 4){
        car.step()
    }
    printStep(car)
}
fun printStep(car: Car) {
    var go = ""
    for(i in 0..<car.position){
        go += "-"
    }
    println("${car.name} : $go")
}
fun input(){
    val carname = Console.readLine()
    val names = carname.split(',')
    for (name in names) {
        checkName(name)
    }
}
fun checkName(input: String) {
    if (input.length > 5 || input.isEmpty()) {
        throw IllegalArgumentException("이름이 5자가 넘어가거나 값이 없습니다.")
    } else {
        CARSNAME.add(input)
    }
}
fun inputRepeat(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val repeat = Console.readLine()
    checkNum(repeat)
    Console.close()
    return repeat.toInt()
}
fun checkNum(repeat: String) {
    try {
        repeat.toInt()
    } catch (e: NumberFormatException){
        throw IllegalArgumentException("숫자가 아닙니다.")
    }
    if (repeat.toInt() < 1) {
        throw IllegalArgumentException("입력 값에 음수가 있습니다.")
    }
}