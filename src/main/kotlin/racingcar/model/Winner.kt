package racingcar.model

data class Winner(private val carList: List<Car>) {
    private var _winnerNameList: List<String> = listOf()

    val winnerList: List<String> get() = _winnerNameList

    init {
        val maxScore = carList.map{ it.score }.max()
        _winnerNameList = carList.filter { it.score == maxScore }.map { it.name }
    }
}