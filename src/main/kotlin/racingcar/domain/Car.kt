package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.utils.Constants.RANGE_START
import racingcar.utils.Constants.RANGE_END
import racingcar.utils.Constants.MIN_MOVEMENT_THRESHOLD

class Car(private val name: String) {
    private var position = 0

    fun moveOrStay() {
        if (isMovable()) {
            position++
        }
    }

    fun showCurrentPositionWithName() {
        println("$name : ${getStringPosition()}")
    }

    fun isWinnerCar(maxDistance: Int): Boolean = maxDistance == position

    fun getPosition() = position

    fun getName() = name

    private fun isMovable(): Boolean = Randoms.pickNumberInRange(RANGE_START, RANGE_END) >= MIN_MOVEMENT_THRESHOLD

    private fun getStringPosition(): String = "-".repeat(position)
}