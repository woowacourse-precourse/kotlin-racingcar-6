package racingcar.domain

import racingcar.utils.Constants.MIN_MOVEMENT_THRESHOLD

class Car(private val name: String) {
    private var position = 0

    fun moveOrStay(randomNumber: Int) {
        if (isMovable(randomNumber)) {
            position++
        }
    }

    override fun toString(): String {
        return "$name : ${getStringPosition()}"
    }

    fun isWinnerCar(maxDistance: Int): Boolean = maxDistance == position

    fun getPosition() = position

    fun getName() = name

    private fun isMovable(randomNumber: Int): Boolean = randomNumber >= MIN_MOVEMENT_THRESHOLD

    private fun isMovable(randomNumber: Int): Boolean = randomNumber >= MIN_MOVEMENT_VALUE

    companion object {
        private const val MIN_MOVEMENT_VALUE = 4
        private const val DEFAULT_POSITION = 0
    }
}