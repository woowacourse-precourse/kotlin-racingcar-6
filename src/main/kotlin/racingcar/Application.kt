package racingcar

import racingcar.game.Game

private val game: Game by lazy { Game() }

fun main() {
    game.startGame()
}
