package racingcar
import racingcar.model.GameModel

fun main() {
    val game = GameController(GameView(InputValidate()), GameModel());
    game.racingGame()
}
