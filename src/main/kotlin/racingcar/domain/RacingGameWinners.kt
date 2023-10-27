package racingcar.domain

class RacingGameWinners(private val winnerList: List<String>) {

    fun getWinners(): List<String> = winnerList
}