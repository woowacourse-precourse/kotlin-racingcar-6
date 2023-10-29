package racingcar

import camp.nextstep.edu.missionutils.Console
import com.sun.tools.example.debug.expr.ExpressionParserConstants.COLON

class Car(val name: String) {

}

class InputHandler {
    private val cars = mutableListOf<Car>()

    fun start() {
        inputCarNames()
        inputCount()
    }
    private fun inputCarNames() {
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        cars.addAll(names.map { Car(it) })
    }

    private fun inputCount(): Int? {
        return Console.readLine()?.toInt()
    }
}

class OutputHandler {
    fun printInputCarName() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printInputCount() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printResult(result: Map<String, String>) {
        println("실행 결과")
        result.forEach { entry ->
            val eachResult = entry.key + COLON + entry.value
            println(eachResult)
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("최종 우승자: " + winners.joinToString(", "))
    }

}

fun main() {
    // TODO: 프로그램 구현
    val inputHandler = InputHandler()
    inputHandler.start()
}
