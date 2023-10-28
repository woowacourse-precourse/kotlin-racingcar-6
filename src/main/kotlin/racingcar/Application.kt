package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val listOfCar = Console.readLine()
        .split(',')
        .map{Car(it)}

    println("시도할 횟수는 몇 회인가요?")
    var round = getUserIntInput()
}
fun getUserIntInput(): Int {
    var input: Int
    try {
        input = Console.readLine().toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
    return input
}
class Car(
    val name: String,
    var position: Int = 0
) {
    init {
        if (name.length > 5) throw IllegalArgumentException()
    }
    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) position += 1
    }
    override fun toString(): String {
        return "$name : " + "-".repeat(position)
    }
}