package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingCarGame {
    private var winningDistance = 0
    private var winners = mutableListOf<String>()

    fun isRandomNumberMet(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4

    fun changeWinner(name: String, distance: Int) {
        winners.clear()
        winners.add(name)
        winningDistance = distance
    }

    fun addWinner(name: String) {
        winners.add(name)
    }

    fun getWinningDistance(): Int = winningDistance

    fun getWinnersListAsString(): String = winners.joinToString(", ")
}