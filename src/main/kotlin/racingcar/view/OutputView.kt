package racingcar.view

import racingcar.model.Car
import racingcar.model.CarGroup

class OutputView {

    fun printInputRaceCarNames() = println(Message.RaceCarNames)

    fun printInputNumberOfAttempts() = println(Message.NumberOfAttempts)

    fun printResult() {
        println()
        println(Message.RaceResult)
    }

    fun printCurrentRaceResult(result: CarGroup) {
        val message = buildString {
            result.cars.forEach { car ->
                appendLine(String.format(Message.RaceResultFormat.toString(), car.name, formatDistance(car)))
            }
        }
        println(message)
    }

    fun printWinner(winners: List<Car>) {
        val nameOfWinners = winners.map { winner -> winner.name }
        print(String.format(Message.WinnerFormat.toString(), formatWinner(nameOfWinners)))
    }

    private fun formatDistance(car: Car): String =
        buildString {
            repeat(car.distance) {
                append("-")
            }
        }

    private fun formatWinner(names: List<String>): String = names.joinToString(", ")

    private enum class Message(private val message: String) {
        RaceCarNames("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        NumberOfAttempts("시도할 횟수는 몇 회인가요?"),
        RaceResult("실행 결과"),
        WinnerFormat("최종 우승자 : %s"),
        RaceResultFormat("%s : %s");

        override fun toString() = message
    }
}