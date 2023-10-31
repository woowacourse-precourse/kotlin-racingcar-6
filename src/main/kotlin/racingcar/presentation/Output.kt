package racingcar.presentation

import racingcar.data.Car
import racingcar.data.CarState

object Output {

    private const val MESSAGE_RESULT = "실행 결과"
    private const val MESSAGE_WINNER = "최종 우승자"

    fun printResult(result: List<Car>) {
        println(MESSAGE_RESULT)
        printTrace(result, 0)
        printWinner(result)
    }

    private fun printTrace(result: List<Car>, depth: Int) {
        val limit = result[0].trace.size
        if (depth >= limit) {
            return
        }
        result.forEach {
            println("${it.name} : ${getTraceToString(it.trace, depth)}")
        }
        println()
        printTrace(result, depth + 1)
    }

    private fun getTraceToString(traces: List<CarState>, depth: Int): String =
        traces.subList(0, depth + 1).joinToString("") { it.symbol }

    private fun printWinner(result: List<Car>) {
        val nameToMoveCount = result.map { it.name to it.trace.count { state -> state == CarState.MOVING_FORWARD } }
        val max = nameToMoveCount.maxOf { (_, count) -> count }
        val winners =
            nameToMoveCount.filter { (_, count) -> count == max }.joinToString(", ") { (name, _) -> name }
        println("$MESSAGE_WINNER : $winners")
    }
}