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

    private fun getStringPosition(): String = "-".repeat(position)
}