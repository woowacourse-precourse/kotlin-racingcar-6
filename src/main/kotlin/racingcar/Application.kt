package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

val INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
val INPUT_REPEAT = "시도할 횟수는 몇 회인가요?"
val NOT_INT_OR_NULL = "숫자가 아니거나 null입니다."
val INPUT_UNDER_ZERO = "입력 값에 음수가 있습니다."
val INPUT_OVER_FIVE_OR_NULL = "이름이 5자가 넘어가거나 값이 없습니다."
val INPUT_HAVE_SPACE = ",뒤에 공백이 있습니다."
val INPUT_DUPLICATE = "중복된 수가 있습니다."
val INPUT_SIZE = "2대 이상 입력해야 합니다."
val SPACE = " "
val MAX_LENGTH = 5
val MOVE = "-"

val cars = mutableListOf<Car>()
val winners = mutableListOf<String>()
fun main() {
    cars.clear()
    winners.clear()
    println(INPUT_NAME)
    input()
    val repeat = inputRepeat()
    processGame(repeat)
    winner()
}
private fun winner() {
    val maxPosition = findMaxPos()
    for (car in cars) {
        if (car.position == maxPosition) {
            winners.add(car.name)
        }
    }
    printWinner(winners)
}

private fun findMaxPos(): Int {
    var max = 0
    for (car in cars) {
        if (car.position >= max) {
            max = car.position
        }
    }
    return max
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
    printStep(car)
}
fun printStep(car: Car) {
    var go = ""
    for(i in 0..<car.position){
        go += MOVE
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
    if (input.length > MAX_LENGTH || input.isEmpty()) {
        throw IllegalArgumentException(INPUT_OVER_FIVE_OR_NULL)
    } else {
        cars.add(Car(input))
    }
}
fun inputRepeat(): Int {
    println(INPUT_REPEAT)
    val repeat = Console.readLine()
    checkNum(repeat)
    Console.close()
    return repeat.toInt()
}
fun checkNum(repeat: String) {
    if (repeat.toIntOrNull() == null) {
        throw IllegalArgumentException(NOT_INT_OR_NULL)
    }
    if (repeat.toInt() < 1) {
        throw IllegalArgumentException(INPUT_UNDER_ZERO)
    }
}