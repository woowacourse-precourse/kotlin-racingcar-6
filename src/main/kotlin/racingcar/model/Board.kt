package racingcar.model

typealias Attempt = Int
typealias Score = Int

class Board private constructor(
    private val scoresByCarName: MutableMap<CarName, Scores>,
) {

    fun writeResult(carName: CarName, attempt: Attempt, score: Score) {
        val scores = scoresByCarName[carName] ?: throw IllegalArgumentException(Error.InvalidName.message)
        scores.addCurrentScore(attempt, score)
    }

    fun getResultByAttempt(attempt: Attempt): List<Pair<CarName, Score>> =
        scoresByCarName.flatMap { (carName, scores) ->
            val score = scores.scoreByAttempt[attempt] ?: throw IllegalArgumentException(Error.InvalidAttempt.message)
            listOf(carName to score)
        }

    companion object {
        fun create(nameOfParticipants: List<CarName>, attempt: Attempt): Board {
            val scoresByCarName = nameOfParticipants.associateWith { Scores.create(attempt) }.toMutableMap()
            return Board(scoresByCarName)
        }
    }

    internal enum class Error(val message: String) {
        InvalidName("대회에 참여한 자동차가 아닙니다. 자동차 이름을 확인해주세요."),
        InvalidAttempt("유효하지 않은 값입니다. attempt 값을 다시 확인해주세요."),
    }
}

class Scores private constructor(private val _scoreByAttempt: MutableMap<Attempt, Score>) {

    val scoreByAttempt: Map<Attempt, Score> get() = _scoreByAttempt

    fun addCurrentScore(attempt: Attempt, score: Score) {
        require(_scoreByAttempt.contains(attempt)) { Error.OverflowAttempt.message }
        _scoreByAttempt[attempt] = score
    }

    companion object {
        private const val SCORE_INITIAL = 0
        private const val FIRST_ATTEMPT = 1

        fun create(attempt: Attempt): Scores {
            val scoreByAttempt = (FIRST_ATTEMPT..attempt).associateWith { SCORE_INITIAL }
            return Scores(scoreByAttempt.toMutableMap())
        }
    }

    internal enum class Error(val message: String) {
        OverflowAttempt("입력한 차수를 넘겼습니다. ")
    }
}