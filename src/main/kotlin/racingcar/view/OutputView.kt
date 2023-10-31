package racingcar.view

import racingcar.model.Attempt
import racingcar.model.Board
import racingcar.model.CarName
import racingcar.model.Score

class OutputView {

    fun printInputRaceCarNames() = println(Message.RaceCarNames)

    fun printInputNumberOfAttempts() = println(Message.NumberOfAttempts)

    fun printCurrentRaceResult(board: Board, lastAttempt: Attempt) {
        val message = buildString {
            appendLine()
            appendLine(Message.RaceResult)
            (1..lastAttempt).forEach { currentAttempt ->
                val carNameAndScoreList = board.getResultByAttempt(currentAttempt)
                appendLine(formatRaceResults(carNameAndScoreList))
                appendLine()
            }
        }
        print(message)
    }

    fun printWinner(winners: List<CarName>) {
        val winnersMessage = Message.WinnerFormat.toString().format(formatWinner(winners))
        print(winnersMessage)
    }

    private fun formatRaceResults(carNameAndScoreList: List<Pair<CarName, Score>>): String =
        carNameAndScoreList.joinToString("\n") { (carName, score) ->
            Message.RaceResultFormat.toString().format(carName, formatScore(score))
        }

    private fun formatScore(score: Score): String = ONE_STEP.repeat(score)

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