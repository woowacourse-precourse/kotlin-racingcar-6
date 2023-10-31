package racingcar.domain

import racingcar.RefereeConstants

class Referee {
    fun findMaxScore(carScore: MutableList<Pair<String, Int>>): Int? {
        return carScore.maxOfOrNull { it.second }
    }

    fun findWinner(carScore: MutableList<Pair<String, Int>>, maxScore: Int?): List<String> {
        val winnerPair = carScore.filter { it.second == maxScore }
        return winnerPair.map { it.first }
    }

    fun printWinner(winnerName: List<String>) {
        println(RefereeConstants.WINNER_MESSAGE + winnerName.joinToString(RefereeConstants.WINNER_SEPARATOR))
    }
}