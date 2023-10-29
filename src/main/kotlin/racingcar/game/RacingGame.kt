package racingcar.game

import racingcar.io.UserInterface

class RacingGame(
    private val ui: UserInterface = UserInterface()
) {

    private val players: List<Player>
    private var rounds: Int
    private var maxProgress: Int = 0

    init {
        val playerNames = askCarNames()
        players = setPlayers(playerNames)
        rounds = askTryNumbers()
    }

    private fun askCarNames(): List<String> {
        return ui.enterCarNames()
    }

    private fun askTryNumbers(): Int {
        return ui.enterTryNumbers()
    }

    private fun setPlayers(playerNames: List<String>): List<Player> {
        val players = mutableListOf<Player>()
        for (name in playerNames) {
            players.add(Player(name, progress = 0))
        }

        return players
    }


    fun play() {
        ui.printResultMessage()
        repeat(rounds) {
            playRound()
        }


    }

    private fun playRound() {
        for (player in players) {
            player.rollTheDice()
        }
        printRoundResult()
        printWinners(getWinner())

    }

    private fun printRoundResult() {
        for (player in players) {
            maintainMaxProgress(player.getProgress())
            ui.printPlayerProgress(player.getPlayerName(), player.getProgress())
        }
        ui.printBlankLine()

    }

    private fun maintainMaxProgress(currentProgress: Int) {
        if (maxProgress < currentProgress) {
            maxProgress = currentProgress
        }

    }

    fun getWinner(): List<String> {
        val winners = mutableListOf<String>()
        for (player in players) {
            if (player.getProgress() == maxProgress) {
                winners.add(player.getPlayerName())
            }
        }
        return winners
    }

    fun printWinners(winners: List<String>) {
        ui.printWinners(winners)
    }


}