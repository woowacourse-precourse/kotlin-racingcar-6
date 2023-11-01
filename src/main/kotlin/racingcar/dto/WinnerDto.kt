package racingcar.dto

class WinnerDto (private val winner: String) {

    fun getWinnersName(): String {
        return winner
    }
}