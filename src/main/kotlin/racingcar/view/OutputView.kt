package racingcar.view

import racingcar.model.Board
import racingcar.model.CarName
import racingcar.model.Round
import racingcar.model.Score

class OutputView {

    fun printInputRaceCarNames() = println(Message.RaceCarNames)

    fun printInputNumberOfAttempts() = println(Message.NumberOfRound)

    fun printCurrentRaceResult(board: Board, round: Round) {
        val message = buildString {
            appendLine()
            appendLine(Message.RaceResult)
            round.forEach { currentRound ->
                val carNameAndScoreList = board.getScoresByRound(currentRound)
                appendLine(formatRaceResults(carNameAndScoreList))
                appendLine()
            }
        }
        print(message)
    }

    fun printWinner(winners: List<CarName>) {
        val winnersMessage = Message.WinnerTemplate.toString().format(formatWinner(winners))
        print(winnersMessage)
    }

    private fun formatRaceResults(carNameAndScoreList: List<Pair<CarName, Score>>): String =
        carNameAndScoreList.joinToString("\n") { (carName, score) ->
            Message.RaceResultTemplate.toString().format(carName, formatScore(score))
        }

    private fun formatScore(score: Score): String = ONE_STEP.repeat(score)

    private fun formatWinner(names: List<CarName>): String = names.joinToString(WINNER_SEPARATOR)

    companion object {
        private const val ONE_STEP = "-"
        private const val WINNER_SEPARATOR = ", "
    }

    private enum class Message(private val message: String) {
        RaceCarNames("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        NumberOfRound("시도할 횟수는 몇 회인가요?"),
        RaceResult("실행 결과"),
        WinnerTemplate("최종 우승자 : %s"),
        RaceResultTemplate("%s : %s");

        override fun toString() = message
    }
}