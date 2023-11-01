package racingcar.model

/**
 * 경기의 모든 진행 결과를 담은 클래스, 참가한 차량 이름과 라운드별 점수가 기록됨
 * */
class Board private constructor(private val scoresByCarName: Map<CarName, Scores>) {

    fun recordRaceResult(carName: CarName, round: Round, score: Score) {
        val scores = scoresByCarName[carName] ?: throw IllegalArgumentException(Error.InvalidName.message)
        scores.addCurrentScore(round, score)
    }

    fun getScoresByRound(round: Round): List<Pair<CarName, Score>> =
        scoresByCarName.flatMap { (carName, scores) ->
            val score = scores.scoreByRound[round] ?: throw IllegalArgumentException(Error.InvalidRound.message)
            listOf(carName to score)
        }

    companion object {
        fun of(nameOfParticipants: List<CarName>, round: Round): Board {
            val scoresByCarName = nameOfParticipants.associateWith { Scores.from(round) }
            return Board(scoresByCarName)
        }
    }

    internal enum class Error(val message: String) {
        InvalidName("대회에 참여한 자동차가 아닙니다. 자동차 이름을 확인해주세요."),
        InvalidRound("유효하지 않은 값입니다. round 값을 다시 확인해주세요."),
    }
}