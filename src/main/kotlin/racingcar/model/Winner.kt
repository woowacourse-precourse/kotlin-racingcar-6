package racingcar.model

class Winner {
    fun calculateWinner(carScore: MutableMap<String, Int>): Set<String> {
        val maxScore = carScore.values.maxOrNull() ?: 0
        val result = carScore.filter { it.value == maxScore }
        return result.keys
    }
}