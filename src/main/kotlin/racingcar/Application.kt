package racingcar

fun main() {
    val game = GameController(GameView(InputValidate()));
    game.racingGame()
}
