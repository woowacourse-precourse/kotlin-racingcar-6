package racingcar.domain

import racingcar.constant.PrintText

class RacingGameWinners(private val winnerNames: List<String>) {

    fun toWinnerNamesGameResult(): String {
        val winnerName = StringBuilder()
        winnerNames.forEachIndexed { index, winner ->
            if (index == winnerNames.lastIndex) {
                winnerName.append(winner)
                return winnerName.toString()
            }
            winnerName.append(winner + PrintText.SEPARATE_WINNER.text)
        }
        return winnerName.toString()
    }
}