package racingcar.game

import racingcar.io.UserInterface

const val INITIAL_PROGRESS = 0

class GameSetting(private val ui: UserInterface = UserInterface()) {

    fun setGame(): RacingGame {
        val carNames = askCarNames()
        val tryNumbers = askTryNumbers()
        val players = setPlayers(carNames)

        return RacingGame(ui, players, tryNumbers, INITIAL_PROGRESS)

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
            players.add(Player(name, progress = INITIAL_PROGRESS))
        }

        return players
    }
}