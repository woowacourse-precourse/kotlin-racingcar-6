package racingcar.model

typealias Attempt = Int
typealias Score = Int

class Board private constructor(
    private val _scoresByCarName: MutableMap<CarName, Scores>,
) {

    fun addScore(carName: CarName, attempt: Attempt, score: Score) {
        val scores = _scoresByCarName[carName]
        scores?.addCurrentScore(attempt, score)
    }

    fun getResultByAttempt(attempt: Attempt): List<Pair<CarName, Score>> =
        _scoresByCarName.flatMap { (carName, scores) ->
            val score = scores.scoreByCarName[attempt]!!
            listOf(carName to score)
        }

    companion object {
        fun create(nameOfParticipants: List<CarName>, attempt: Attempt): Board {
            val scoresByCarName = nameOfParticipants.associateWith { Scores.create(attempt) }.toMutableMap()
            return Board(scoresByCarName)
        }
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