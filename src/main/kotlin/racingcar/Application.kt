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

    println("실행 결과")
    for (i in 0 until round) {
        progressRound(listOfCar)
        println()
    }
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
fun progressRound(
    listOfCar:List<Car>
)
{
    listOfCar.forEach {
        it.move()
        print(it)
    }
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