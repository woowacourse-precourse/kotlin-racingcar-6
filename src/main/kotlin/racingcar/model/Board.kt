package racingcar.model

typealias Attempt = Int
typealias Score = Int

class Board private constructor(
    private val scoresByCarName: MutableMap<CarName, Scores>,
) {

    fun addScore(carName: CarName, attempt: Attempt, score: Score) {
        val scores = scoresByCarName[carName] ?: throw IllegalArgumentException(Error.InvalidName.message)
        scores.addCurrentScore(attempt, score)
    }

    fun getResultByAttempt(attempt: Attempt): List<Pair<CarName, Score>> =
        scoresByCarName.flatMap { (carName, scores) ->
            val score = scores.scoreByCarName[attempt]!!
            listOf(carName to score)
        }

    companion object {
        fun create(nameOfParticipants: List<CarName>, attempt: Attempt): Board {
            val scoresByCarName = nameOfParticipants.associateWith { Scores.create(attempt) }.toMutableMap()
            return Board(scoresByCarName)
        }
    }

    internal enum class Error(val message: String) {
        InvalidName("대회에 참여한 자동차가 아닙니다. 자동차 이름을 확인해주세요.");
    }
}

class Scores private constructor(private val _scoreByAttempt: MutableMap<Attempt, Score>) {

    val scoreByCarName get() = _scoreByAttempt.toMap()

    fun addCurrentScore(attempt: Attempt, score: Score) {
        _scoreByAttempt[attempt] = score
    }

    companion object {
        fun create(attempt: Attempt): Scores =
            (1..attempt).associateWith { 0 }.toMutableMap().run { Scores(this) }
    }
}