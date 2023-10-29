package racingcar.view

import racingcar.Car
import racingcar.CarGroup

class OutputView {

    fun printInputRaceCarNames() = println(Message.RaceCarNames)

    fun printInputNumberOfAttempts() = println(Message.NumberOfAttempts)

    fun printAllRaceResults(result: CarGroup) {
        val message = buildString {
            appendLine(Message.Result)
            result.cars.forEach { car ->
                appendLine(String.format(Message.ResultFormat.toString(), car.name, car.distance))
            }
        }
        println(message)
    }

    fun printWinner(winners: List<Car>) {
        val nameOfWinners = winners.map { winner -> winner.name }
        print(String.format(Message.WinnerFormat.toString(), Message.formatWinner(nameOfWinners)))
    }

    private enum class Message(private val message: String) {
        RaceCarNames("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        NumberOfAttempts("시도할 횟수는 몇 회인가요?"),
        Result("실행 결과"),
        WinnerFormat("최종 우승자 : %s"),
        ResultFormat("%s : %s");

        override fun toString() = message

        companion object {
            fun formatWinner(names: List<String>): String =
                buildString {
                    append(names).append(", ")
                }.dropLast(2)
        }
    }
}