package racingcar.model

data class Winner(
    private val carList: List<Car>,
) {
    private var _winnerNameList: List<String> = listOf()
    val winnerList: List<String> get() = _winnerNameList

    init {
        val bestScore = carList.maxOf { it.score }
        _winnerNameList = carList.filter { it.score == bestScore }
            .map { it.name }
    }
}