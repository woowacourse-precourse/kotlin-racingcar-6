package racingcar.model

import racingcar.utils.RandomUtils
import racingcar.views.OutputView

class SoloRacingGame(private val randomUtils: RandomUtils, private val outputView: OutputView) {

    companion object {
        const val DEFAULT_SCORE = 0
        const val SOLO_GAME_COUNT = 2
        const val SOLO_GAME_MIN_WIN_COUNT = 1
        const val ADVANCE_MINIMUM = 4
    }

    fun soloCarGame(inputCarName: String) {
        val soloCount = soloRacingGameLogic(inputCarName)
        checkSoloWinner(inputCarName, soloCount)
    }

    private fun checkPositiveForward(randomNum: Int): Boolean {
        return randomNum >= ADVANCE_MINIMUM
    }

    private fun soloRacingGameLogic(inputCarName: String): Int {
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
        return soloCount
    }

    private fun checkSoloWinner(inputCarName: String, soloCount: Int) {
        if (soloCount >= SOLO_GAME_MIN_WIN_COUNT) {
            soloRacingWinner(inputCarName)
        } else {
            noSoloRacingWinner()
        }
    }

    private fun soloRacingWinner(inputCarName: String) {
        println(OutputView.WINNER_MESSAGE + inputCarName)
    }

    private fun noSoloRacingWinner() {
        println(OutputView.NO_WINNER_MESSAGE)
    }
}
