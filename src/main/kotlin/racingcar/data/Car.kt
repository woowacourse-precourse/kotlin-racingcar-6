package racingcar.data

data class Car(
    val name: String,
    val location: Int = 0
) {
    private var move: Int = 0

    fun changeMove(move: Int) {
        this.move = move
    }

    fun getMove(): Int = this.move
}