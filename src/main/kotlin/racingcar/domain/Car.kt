package racingcar.domain

class Car(
    private val name: String,
    private var position: Int = DEFAULT_POSITION,
) {
    fun moveOrStay(randomNumber: Int) {
        if (isMovable(randomNumber)) {
            position++
        }
    }

    override fun toString(): String {
        return "$name : ${getVisualPosition()}"
    }

    fun isWinner(maxDistance: Int): Boolean = maxDistance == position

    fun getPosition() = position

    fun getName() = name

    private fun getVisualPosition(): String = "-".repeat(position)

    private fun isMovable(randomNumber: Int): Boolean = randomNumber >= MIN_MOVEMENT_VALUE

    companion object {
        private const val MIN_MOVEMENT_VALUE = 4
        private const val DEFAULT_POSITION = 0
    }
}