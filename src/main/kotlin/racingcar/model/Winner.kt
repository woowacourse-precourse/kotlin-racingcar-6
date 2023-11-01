package racingcar.model

data class Winner(
    private val carList: List<Car>,
) {
    private var _winnerNameList: List<String> = listOf()
    internal val winnerList: List<String> get() = _winnerNameList

    init {
        val scoreList = carList.map { it.score }
        val bestScore = bestScoreCalculate(scoreList)

        require(bestScore >= MIN_BSET_SCORE) { ZERO_SCORE_IS_NOT_WINNER }
        winnerNameListSet(carList, bestScore)
    }

    private fun bestScoreCalculate(scoreList: List<Int>) = scoreList.maxOf { it }

    private fun winnerNameListSet(carList: List<Car>, bestScore: Int) {
        _winnerNameList = carList.filter {
            it.score == bestScore
        }.map { it.name }
    }

    companion object {
        private const val MIN_BSET_SCORE = 1

        internal const val ZERO_SCORE_IS_NOT_WINNER = "0점으로 우승할 수 없습니다."
    }
}