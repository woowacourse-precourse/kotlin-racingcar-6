package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

val cars = mutableListOf<Car>()
val winners = mutableListOf<String>()
val error = Error()
var MAX = 0
val INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
val INPUT_REPEAT = "시도할 횟수는 몇 회인가요?"
val MOVE = "-"

fun main() {
    println(INPUT_NAME)
    input()
    val repeat = inputRepeat()
    processGame(repeat)
    findMaxPos()
    winner()
}
private fun winner() {
    for (car in cars) {
        if (car.position == MAX) {
            winners.add(car.name)
        }
    }
    printWinner(winners)
}

private fun findMaxPos() {
    for (car in cars) {
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
    for(car in cars){
        var random = Randoms.pickNumberInRange(0, 9)
        step(random,car)
    }
    println()
}
fun step(random: Int, car: Car) {
    if(random >= 4){
        car.step()
    }
    println("${car.name} : ${MOVE.repeat(car.position)}")
}
fun input(){
    val carname = Console.readLine()
    val names = carname.split(',')
    error.checkName(names)
    for (name in names) {
        cars.add(Car(name))
    }
}
fun inputRepeat(): Int {
    println(INPUT_REPEAT)
    val repeat = Console.readLine()
    error.checkNum(repeat)
    Console.close()
    return repeat.toInt()
}