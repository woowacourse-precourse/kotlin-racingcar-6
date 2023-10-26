package racingcar.game

class Car (private val name: String) {
    private var distance = STARTING_POINT

    override fun toString(): String {
        return "$name : ${"-".repeat(distance)}"
    }

    fun getDistance() = distance

    fun move() {
        distance++
    }

    companion object {
        private const val STARTING_POINT = 0
    }
}