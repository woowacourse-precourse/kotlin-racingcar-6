package racingcar.game

import racingcar.io.UserInterface

class RacingGame(
    private val ui: UserInterface,
    private val players: List<Player>,
    private var rounds: Int,
    private var maxProgress: Int
) {

    fun play() {
        ui.printResultMessage()

        repeat(rounds) {
            playRound()
        }
        printWinners(getWinner())
    }

    private fun playRound() {
        for (player in players) {
            player.playGame()
        }
        printRoundResult()
    }

    private fun printRoundResult() {
        for (player in players) {
            updateMaxProgress(player.getProgress())
            ui.printPlayerProgress(player.getPlayerName(), player.getProgress())
        }
        ui.printBlankLine()
    }

    private fun updateMaxProgress(currentProgress: Int) {
        if (maxProgress < currentProgress) {
            maxProgress = currentProgress
        }
    }

    private fun getWinner(): List<String> {
        val winners = mutableListOf<String>()
        for (player in players) {
            if (player.getProgress() == maxProgress) {
                winners.add(player.getPlayerName())
            }
        }
        return winners
    }

    private fun printWinners(winners: List<String>) {
        ui.printWinners(winners)
    }


}