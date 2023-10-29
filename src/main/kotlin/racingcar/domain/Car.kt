package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(private val name: String) {
    private var position = 0

    fun moveOrStay() {
        if (isMovable()) {
            position++
        }
    }

    fun showCurrentPositionWithName() {
        val positionString = "-".repeat(position)
        val result = "$name : $positionString"
        println(result)
    }

    fun getPosition() = position

    fun getName() = name

    fun isWinnerCar(maxDistance : Int) : Boolean = maxDistance == position

    private fun isMovable(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}