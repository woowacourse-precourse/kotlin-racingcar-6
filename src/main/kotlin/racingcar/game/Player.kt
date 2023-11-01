package racingcar.game

class Player(
    private val name: String,
    private var progress: Int,
    private val dice: Dice = Dice()
) {

    fun playGame() {
        if (dice.goStop()) {
            progress++
        }
    }

    fun getPlayerName(): String {
        return name
    }

    fun getProgress(): Int {
        return progress
    }
}