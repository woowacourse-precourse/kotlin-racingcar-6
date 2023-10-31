package racingcar.domain

import racingcar.constant.PrintText

class RacingGameWinners(private val winnerNames: List<String>) {

    fun toWinnerNamesGameResult(): String {
        return winnerNames.joinToString(separator = PrintText.SEPARATE_WINNER.text)
    }
}