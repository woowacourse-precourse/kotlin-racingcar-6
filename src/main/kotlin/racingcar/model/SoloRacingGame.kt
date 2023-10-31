package racingcar.model

import racingcar.controller.randomUtils
import racingcar.views.OutputView

class SoloRacingGame {

    companion object {
        const val DEFAULT_SCORE = 0
        const val SOLO_GAME_COUNT = 2
        const val SOLO_GAME_MIN_WIN_COUNT = 1
        const val ADVANCE_MINIMUM = 4
    }

    private val outputView = OutputView()

    fun soloCarGame(inputCarName: String) {
        outputView.printSoloGameRules()
        var soloCount = DEFAULT_SCORE
        repeat(SOLO_GAME_COUNT) {
            val randomNum = randomUtils.getRandom()
            if (checkPositiveForward(randomNum)) {
                soloCount++
            }
            val forward = "-".repeat(soloCount)
            outputView.printSoloGameResult(inputCarName, forward)
        }

        if (soloCount >= SOLO_GAME_MIN_WIN_COUNT) {
            outputView.printSoloWinner(inputCarName)
        } else {
            outputView.printNoWinner()
        }
    }

    private fun checkPositiveForward(randomNum: Int): Boolean {
        return randomNum >= ADVANCE_MINIMUM
    }
}
