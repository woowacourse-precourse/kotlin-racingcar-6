package racingcar.dto

class WinnerDTO (private val winner: String) {

    fun getWinnersName(): String {
        return winner
    }
}