package racingcar.view

import racingcar.model.*

class OutputView {

    fun printInputRaceCarNames() = println(Message.RaceCarNames)

    fun printInputNumberOfAttempts() = println(Message.NumberOfAttempts)

    fun printCurrentRaceResult(board: Board, lastAttempt: Attempt) {
        println()
        val message = buildString {
            appendLine(Message.RaceResult)
            repeat(lastAttempt) { currentAttempt ->
                board.getResultByAttempt(currentAttempt).forEach { (carName, score) ->
                    appendLine(String.format(Message.RaceResultFormat.toString(), carName, formatDistance(score)))
                }
            }
        }
        println(message)
    }

    fun printWinner(winners: List<CarName>) {
        print(String.format(Message.WinnerFormat.toString(), formatWinner(winners)))
    }

    private fun formatDistance(score: Score): String =
        buildString {
            repeat(score) { append(ONE_STEP) }
        }

    private fun formatWinner(names: List<CarName>): String = names.joinToString(", ")

    companion object {
        private const val ONE_STEP = "-"
    }

    private enum class Message(private val message: String) {
        RaceCarNames("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        NumberOfAttempts("시도할 횟수는 몇 회인가요?"),
        RaceResult("실행 결과"),
        WinnerFormat("최종 우승자 : %s"),
        RaceResultFormat("%s : %s");

        override fun toString() = message
    }
}