package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.views.OutputView

class SoloRacingGame {

    private val outputView = OutputView()

    fun soloCarGame(inputCarName: String) {
        outputView.printSoloGameRules()
        var soloCount = 0
        repeat(2) {
            val randomNum = Randoms.pickNumberInRange(0, 9)
            if (checkPositiveForward(randomNum)) {
                soloCount++
            }
            val forward = "-".repeat(soloCount)
            outputView.printSoloGameResult(inputCarName, forward)
        }

        if (soloCount >= 1) {
            outputView.printSoloWinner(inputCarName)
        } else {
            outputView.printNoWinner()
        }
    }

    private fun checkPositiveForward(randomNum: Int): Boolean {
        return randomNum >= 4
    }
}
