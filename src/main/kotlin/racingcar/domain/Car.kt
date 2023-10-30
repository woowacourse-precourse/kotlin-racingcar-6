package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.utils.Constants.RANGE_START
import racingcar.utils.Constants.RANGE_END
import racingcar.utils.Constants.MIN_MOVEMENT_THRESHOLD

class Car(private val name: String) {
    private var position = 0

    fun moveOrStay(randomNumber: Int) {
        if (isMovable(randomNumber)) {
            position++
        }
    }

    fun showCurrentPositionWithName() {
        println("$name : ${getStringPosition()}")
    }

    fun isWinnerCar(maxDistance: Int): Boolean = maxDistance == position

    fun getPosition() = position

    fun getName() = name

    private fun isMovable(randomNumber: Int): Boolean = randomNumber >= MIN_MOVEMENT_THRESHOLD

    private fun getStringPosition(): String = "-".repeat(position)
}