package racingcar.game

import racingcar.io.UserInterface

class RacingGame(
    private val ui: UserInterface = UserInterface()
) {

    private val players: List<Player>
    private var rounds: Int

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

    }

    private fun printRoundResult() {
        for (player in players) {
            ui.printPlayerProgress(player.getPlayerName(), player.getProgress())
        }
        ui.printBlankLine()

    }


}