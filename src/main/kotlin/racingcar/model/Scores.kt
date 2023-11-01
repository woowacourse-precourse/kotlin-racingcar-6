package racingcar.model

typealias Score = Int

class Scores private constructor(private val _scoreByRound: MutableMap<Round, Score>) {

    val scoreByRound: Map<Round, Score> get() = _scoreByRound

    fun addCurrentScore(round: Round, score: Score) {
        require(_scoreByRound.contains(round)) { Error.OverflowRound.message }
        _scoreByRound[round] = score
    }

    companion object {
        private const val SCORE_INITIAL = 0

        fun from(lastRound: Round): Scores {
            val scoreByRound = lastRound.toListOfRounds().associateWith { SCORE_INITIAL }
            return Scores(scoreByRound.toMutableMap())
        }
    }

    internal enum class Error(val message: String) {
        OverflowRound("입력한 차수를 넘겼습니다.")
    }
}