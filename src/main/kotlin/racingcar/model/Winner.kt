package racingcar.model

data class Winner(
    private val carList: List<Car>,
) {
    private var _winnerNameList: List<String> = listOf()
    val winnerList: List<String> get() = _winnerNameList

    init {
        val scoreList = carList.map { it.score }
        val bestScore = bestScoreCalculate(scoreList)
        winnerNameListSet(carList, bestScore)
    }

    private fun bestScoreCalculate(scoreList: List<Int>) = scoreList.maxOf { it }

    private fun winnerNameListSet(carList: List<Car>, bestScore: Int) {
        _winnerNameList = carList.filter {
            it.score == bestScore
        }.map { it.name }
    }
}