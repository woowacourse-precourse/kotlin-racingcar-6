package racingcar.car

data class Car(
    val name: String,
    val strategy: MoveStrategy
) {
    var forward: Int = 0
        private set

    fun moveForward() {
        if (strategy.isMovable()) forward += 1
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(forward)}"
    }
}
