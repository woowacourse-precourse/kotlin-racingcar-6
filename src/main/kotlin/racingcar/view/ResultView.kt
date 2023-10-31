package racingcar.view

import racingcar.constant.Constants.FINAL_WINNER_STRING

class ResultView {
    fun printWinner(carStatus: MutableMap<String, String>) {
        val longestDistance = carStatus.values.maxByOrNull { it.length }?.length
        val finalWinner = carStatus.filter { it.value.length == longestDistance }.keys
        print(FINAL_WINNER_STRING + finalWinner.joinToString(", "))
    }
}
