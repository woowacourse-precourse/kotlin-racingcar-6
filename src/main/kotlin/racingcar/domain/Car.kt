package racingcar.domain

class Car(
    private val name: String,
    private var position: Int = DEFAULT_POSITION,
) {
    fun isWinner(maxDistance: Int): Boolean = maxDistance == position

    fun moveOrStay(randomNumber: Int) {
        if (isMovable(randomNumber)) {
            position++
        }
    }

    private fun isMovable(randomNumber: Int): Boolean = randomNumber >= MIN_MOVEMENT_VALUE

    override fun toString(): String {
        return "$name : ${getVisualPosition()}"
    }

    private fun getVisualPosition(): String = "-".repeat(position)

    fun getPosition() = position

    fun getName() = name

    companion object {
        private const val MIN_MOVEMENT_VALUE = 4
        private const val DEFAULT_POSITION = 0
    }
}