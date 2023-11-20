package racingcar

import racingcar.Racing.GameConstants
import viewModel.ValidInput

fun main() {
    val inputUser = InputUser()
    val gamePlaying = Racing()
    val carNames = inputUser.inputCarName()

    if (ValidInput().validName(carNames)) {
        GameConstants.scoreList.clear()
        inputUser.printlnGameCountMent()
        val gameCount = ValidInput().validInputGameCount()
        gamePlaying.outputStartMent()

        for (round in 1..gameCount) {
            var gameInfo = gamePlaying.generateNumber(carNames)
            gamePlaying.printPerExecutionResult(gameInfo)
            Racing().calculateScore(gameInfo)
        }
    }
    Racing().printlnResult()
}



